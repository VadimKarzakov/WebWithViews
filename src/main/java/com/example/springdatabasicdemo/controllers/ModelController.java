package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ModelCategoryDto;
import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
import com.example.springdatabasicdemo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping()
    Iterable<ModelDto> all() {
        return modelService.getAll();
    }
    @GetMapping("/{id}")
    Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }

    @GetMapping("/getByBrand")
    List<ModelCategoryDto> getByBrand(@RequestParam(name = "name") String name) {
        return modelService.findPriceOfFigureByNickname(name);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        modelService.destroyById(id);
    }
    @PostMapping()
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.create(model);
    }
}
