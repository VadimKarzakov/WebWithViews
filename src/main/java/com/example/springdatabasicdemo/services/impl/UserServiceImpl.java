package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto userDto) {
        User s = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(s), UserDto.class);
    }

    @Override
    public void destroy(UserDto userDto) {
        userRepository.deleteById(userDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }
}
