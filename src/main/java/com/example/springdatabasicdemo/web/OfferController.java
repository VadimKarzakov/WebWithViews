package com.example.springdatabasicdemo.web;

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


    private OfferService offerService;

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    // Обработчик HTTP GET-запроса, который возвращает список всех предложений
    @GetMapping()
    Iterable<OfferDto> all() {//просмотр
        return offerService.getAll();
    }

    // Обработчик HTTP GET-запроса, который возвращает информацию о предложении по его идентификатору
    @GetMapping("/{id}")
    Optional<OfferDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(offerService.find(id).orElseThrow(() -> new OfferNotFoundExeption(id)));
    }

    // Обработчик HTTP DELETE-запроса, который удаляет предложение по его идентификатору
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        offerService.destroyById(id);
    }

    // Обработчик HTTP POST-запроса, который создает новое предложение на основе переданных данных
    @PostMapping()
    OfferDto update(@RequestBody OfferDto offer) {
        return offerService.create(offer);
    }
}
