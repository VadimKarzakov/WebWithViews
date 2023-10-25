package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.exeptions.OfferNotFoundExeption;
import com.example.springdatabasicdemo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping()
    Iterable<OfferDto> all() {
        return offerService.getAll();
    }
    @GetMapping("/{id}")
    Optional<OfferDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(offerService.find((id)).orElseThrow(() -> new OfferNotFoundExeption(id)));
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        offerService.destroyById(id);
    }
    @PostMapping()
    OfferDto update(@RequestBody OfferDto offer) {
        return offerService.create(offer);
    }
}
