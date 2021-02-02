package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractEntity {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
