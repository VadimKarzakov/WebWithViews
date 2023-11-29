package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.exeptions.UserRoleNotFoundExeption;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class UserRoleController {


    private UserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // Обработчик HTTP GET-запроса, который возвращает список всех ролей пользователей
    @GetMapping()
    Iterable<UserRoleDto> all() {
        return userRoleService.getAll();
    }

    // Обработчик HTTP GET-запроса, который возвращает информацию о роли пользователя по её идентификатору
    @GetMapping("/{id}")
    Optional<UserRoleDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(userRoleService.find(id).orElseThrow(() -> new UserRoleNotFoundExeption(id)));
    }

    // Обработчик HTTP POST-запроса, который создает новую роль пользователя на основе переданных данных
    @PostMapping()
    UserRoleDto update(@RequestBody UserRoleDto role) {
        return userRoleService.create(role);
    }

    // Обработчик HTTP DELETE-запроса, который удаляет роль пользователя по её идентификатору
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        userRoleService.destroyById(id);
    }
}
