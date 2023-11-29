package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // Обработчик HTTP GET-запроса, который возвращает список всех пользователей
    @GetMapping()
    Iterable<UserDto> all() {
        return userService.getAll();
    }

    // Обработчик HTTP GET-запроса, который возвращает информацию о пользователе по его идентификатору
    @GetMapping("/{id}")
    Optional<UserDto> get(@PathVariable UUID id) throws Throwable {
        // Примечание: в коде есть недоразумение в обработке исключений, так как "throws Throwable" лишнее
        return Optional.ofNullable((UserDto) userService.find((id)).orElseThrow(() -> new UserNotFoundExeption(id)));
    }

    // Обработчик HTTP DELETE-запроса, который удаляет пользователя по его идентификатору
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        userService.destroyById(id);
    }

    // Обработчик HTTP POST-запроса, который создает нового пользователя на основе переданных данных
    @PostMapping()
    UserDto update(@RequestBody UserDto user) {
        return userService.create(user);
    }
}
