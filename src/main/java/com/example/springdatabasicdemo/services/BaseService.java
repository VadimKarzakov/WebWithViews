package com.example.springdatabasicdemo.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface BaseService<T, ID>{

    T create(T t);//создает новую сущность.

    void destroy(T t);//Удаляет данный объект.

    void destroyById(ID id);//Удаляет объект по его идентификатору.

    Optional<T> find(ID id);// извлекает объект по его идентификатору

    List<T> getAll();//извлекает список всех объектов.

}
