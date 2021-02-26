package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {
    private String Name;
//    @OneToMany(mappedBy="category")
//    private Set<Transaction> transactions;
    public String getName() {
        return Name;
    }
    @OneToMany (mappedBy="transactions", fetch= FetchType.EAGER)
    private Collection<com.example.demo.model.Transactions> Transactions;
    public void setName(String name) {
        Name = name;
    }
}
