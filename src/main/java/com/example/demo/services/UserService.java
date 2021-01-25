package com.example.demo.services;

import com.example.demo.model.User;


import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface UserService {

    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

    //Product saveOrUpdateProductForm(ProductForm productForm);
}
