package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OfferDto create(OfferDto offerDto) {
        Offer s = modelMapper.map(offerDto, Offer.class);
        return modelMapper.map(offerRepository.save(s), OfferDto.class);
    }

    @Override
    public void destroy(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Optional<OfferDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }

    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }
}
