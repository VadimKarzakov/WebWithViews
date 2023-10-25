package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService<T, ID>{

    UserDto create(UserDto t);//создает новую сущность.

    void destroy(UserDto t);//Удаляет данный объект.

    void destroyById(UUID id);//Удаляет объект по его идентификатору.

    Optional<UserDto> find(UUID  id);// извлекает объект по его идентификатору

    List<UserDto> getAll();//извлекает список всех объектов.

}