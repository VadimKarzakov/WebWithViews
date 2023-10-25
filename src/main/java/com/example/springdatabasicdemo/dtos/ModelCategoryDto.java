package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.constants.Category;

public class ModelCategoryDto {
    String name;

    Category category;

    public ModelCategoryDto(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public ModelCategoryDto() {
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
}
