package com.example.springdatabasicdemo.web;

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


    private ModelService modelService;

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    // Обработчик HTTP GET-запроса, который возвращает список всех моделей
    @GetMapping()
    Iterable<ModelDto> all() {
        return modelService.getAll();
    }

    // Обработчик HTTP GET-запроса, который возвращает информацию о модели по её идентификатору
    @GetMapping("/{id}")
    Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }

    // Обработчик HTTP GET-запроса, который возвращает список моделей по имени бренда
    @GetMapping("/getByBrand")
    List<ModelCategoryDto> getByBrand(@RequestParam(name = "name") String name) {
        return modelService.findPriceOfFigureByNickname(name);
    }

    // Обработчик HTTP DELETE-запроса, который удаляет модель по её идентификатору
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        modelService.destroyById(id);
    }

    // Обработчик HTTP POST-запроса, который создаёт новую модель на основе переданных данных
    @PostMapping()
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.create(model);
    }
}
