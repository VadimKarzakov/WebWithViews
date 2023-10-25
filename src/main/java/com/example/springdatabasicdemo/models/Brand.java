package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity//используется для указания на то, что этот класс является сущностью и должен управляться JPA.
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private Set<Model> models = new HashSet<>();

    public Brand() {
    }

    void addModel(Model model){models.add(model);}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
