package com.example.demo.services;


import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface GeneralService<TModel>{

    List<Model> listAll();

    Model getById(Long id);

    Model saveOrUpdate(Model model);

    void delete(Long id);

    //Product saveOrUpdateProductForm(ProductForm productForm);
}
