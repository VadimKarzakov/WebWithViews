package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ModelCategoryDto;
import com.example.springdatabasicdemo.dtos.ModelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService{

    ModelDto create(ModelDto t);//создает новую сущность.

    void destroy(ModelDto t);//Удаляет данный объект.

    void destroyById(UUID id);//Удаляет объект по его идентификатору.

    Optional<ModelDto> find(UUID id);// извлекает объект по его идентификатору

    List<ModelDto> getAll();//извлекает список всех объектов.

    List<ModelCategoryDto> findPriceOfFigureByNickname(String brand_name)//извлекает список объектов ModelCategoryDto по названию бренда.
    ;
}
