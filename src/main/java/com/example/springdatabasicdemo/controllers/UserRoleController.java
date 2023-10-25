package com.example.springdatabasicdemo.controllers;

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

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping()
    Iterable<UserRoleDto> all() {
        return userRoleService.getAll();
    }
    @GetMapping("/{id}")
    Optional<UserRoleDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(userRoleService.find((id)).orElseThrow(() -> new UserRoleNotFoundExeption(id)));
    }

    @PostMapping()
    UserRoleDto update(@RequestBody UserRoleDto role) {
        return userRoleService.create(role);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        userRoleService.destroyById(id);
    }

}