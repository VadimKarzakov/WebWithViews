package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BrandDto create(BrandDto brandDto) {
        Brand s = modelMapper.map(brandDto, Brand.class);
        return modelMapper.map(brandRepository.save(s), BrandDto.class);
    }

    @Override
    public void destroy(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Optional<BrandDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }
}
