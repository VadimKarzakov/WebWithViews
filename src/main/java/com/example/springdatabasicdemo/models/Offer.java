package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Transmission;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    @Column(name = "description")
    private String description;
    @Column(name = "engine")
    private Engine engine;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "price")
    private int price;
    @Column(name = "transmission")
    private Transmission transmission;
    @Column(name = "year")
    private int year;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    public Offer() {
    }

    public Offer(
            String description,
            Engine engine,
            String imageUrl,
            int mileage,
            int price,
            Transmission transmission,
            int year,
            Date created,
            Date modified,
            Model model,
            User seller
    ) {
        super.created = created;
        super.modified = modified;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public Offer(String description, Engine engine, String imageUrl, int mileage, int price, Transmission transmission, int year, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                ", id=" + id +
                '}';
    }
}
