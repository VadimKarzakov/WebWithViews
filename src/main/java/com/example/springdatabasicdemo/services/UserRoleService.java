package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService{

    UserRoleDto create(UserRoleDto t);//создает новую сущность.

    void destroy(UserRoleDto t);//Удаляет данный объект.

    void destroyById(UUID id);//Удаляет объект по его идентификатору.

    Optional<UserRoleDto> find(UUID id);// извлекает объект по его идентификатору

    List<UserRoleDto> getAll();//извлекает список всех объектов.

}