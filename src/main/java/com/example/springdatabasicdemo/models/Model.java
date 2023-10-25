package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private Category category;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    private Set<Offer> offers = new HashSet<>();
    void addModel(Offer offer){offers.add(offer);}

    public Model() {
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, Brand brand, Set<Offer> offers) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
        this.offers = offers;
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
