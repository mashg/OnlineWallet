package com.example.demo.services;


import com.example.demo.repositories.GeneralRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;
@Service
public class GeneralServiceImpl<TModel> implements GeneralService<TModel> {
   // private GeneralRep<TModel> generalRep;
    //private ProductFormToProduct productFormToProduct;

    @Autowired
    public GeneralServiceImpl() {
       // this.generalRep= genRepository;
        // this.productFormToProduct = productFormToProduct;
    }


    @Override
    public List<Model> listAll() {
        List<Model> models = new ArrayList<>();
        //generalRep.findAll().forEach(models::add); //fun with Java 8
        return models;
    }

    @Override
    public org.springframework.ui.Model getById(Long id) {
        return null;
    }

    @Override
    public Model saveOrUpdate(Model model) {
        return null;
    }


    @Override
    public void delete(Long id) {

    }
}
