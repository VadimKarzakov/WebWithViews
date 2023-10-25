package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService{

    BrandDto create(BrandDto t);//создает новую сущность.

    void destroy(BrandDto t);//Удаляет данный объект.

    void destroyById(UUID id);//Удаляет объект по его идентификатору.

    Optional<BrandDto> find(UUID id);// извлекает объект по его идентификатору

    List<BrandDto> getAll();//извлекает список всех объектов.

}
