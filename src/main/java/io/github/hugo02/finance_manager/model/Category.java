package io.github.hugo02.finance_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Long id;
    private String name;
    
    protected Category() {}

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Category[id=%d, name='%s']", id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }


}
