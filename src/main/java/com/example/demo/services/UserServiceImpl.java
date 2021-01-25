package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    //private ProductFormToProduct productFormToProduct;

    @Autowired
    public UserServiceImpl(UserRepository productRepository) {
        this.userRepository = productRepository;
       // this.productFormToProduct = productFormToProduct;
    }


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
