package com.example.demo;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class DemoApplicationTests {

    private final String redirectUrl = "http://localhost:8080/";
    private final String authorizeUrlPattern = "http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/auth?response_type=code&client_id=barClient&scope=%s&redirect_uri=" + redirectUrl;
    private final String tokenUrl = "http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/token";
    private final String resourceUrl = "http://localhost:8082/resource-server-opaque/bars";
    
    @Test
    void contextLoads() {
    }

    @Test
    public void givenUserWithReadScope_whenGetFooResource_thenSuccess() {
        String accessToken = obtainAccessToken("read");

        Response response = RestAssured.given()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .get("http://localhost:8081/resource-server-jwt/user");
              assertThat(response.as(List.class)).hasSizeGreaterThan(0);
    }
    

    private String obtainAccessToken(String scopes) {
        // obtain authentication url with custom codes
        Response response = RestAssured.given()
            .redirects()
            .follow(false)
            .get(String.format(authorizeUrlPattern, scopes));
        String authSessionId = response.getCookie("AUTH_SESSION_ID");
        String kcPostAuthenticationUrl = response.asString()
            .split("action=\"")[1].split("\"")[0].replace("&amp;", "&");

        // obtain authentication code and state
        response = RestAssured.given()
            .redirects()
            .follow(false)
            .cookie("AUTH_SESSION_ID", authSessionId)
            .formParams("username", "john@test.com", "password", "123", "credentialId", "")
            .post(kcPostAuthenticationUrl);
        assertThat(HttpStatus.FOUND.value()).isEqualTo(response.getStatusCode());

        // extract authorization code
        String location = response.getHeader(HttpHeaders.LOCATION);
        String code = location.split("code=")[1].split("&")[0];

        // get access token
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_id", "barClient");
        params.put("redirect_uri", redirectUrl);
        params.put("client_secret", "barClientSecret");
        response = RestAssured.given()
            .formParams(params)
            .post(tokenUrl);
        return response.jsonPath()
            .getString("access_token");
    }

}
