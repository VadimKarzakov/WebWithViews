package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OfferDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService{

     OfferDto create(OfferDto t);//создает новую сущность.

    void destroy(OfferDto t);//Удаляет данный объект.

    void destroyById(UUID id);//Удаляет объект по его идентификатору.

    Optional<OfferDto> find(UUID id);// извлекает объект по его идентификатору

    List<OfferDto> getAll();//извлекает список всех объектов.

}