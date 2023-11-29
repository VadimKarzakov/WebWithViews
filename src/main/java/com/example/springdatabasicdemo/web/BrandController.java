package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.exeptions.BrandNotFoundExeption;
import com.example.springdatabasicdemo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {


    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService){

        this.brandService=brandService;
    }

    @GetMapping()
    Iterable<BrandDto> all() {//указывает на обработку HTTP-запроса GET
        return brandService.getAll();
    }
    @GetMapping("/{id}")//поиск бренда по указанному идентификатору
    Optional<BrandDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(brandService.find((id)).orElseThrow(() -> new BrandNotFoundExeption(id)));
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        brandService.destroyById(id);
    }//обрабатывает HTTP-запрос DELETE для удаления бренда с указанным идентификатором.
    @PostMapping()
    BrandDto update(@RequestBody BrandDto brand) {
        return brandService.create(brand);
    }//обрабатывает HTTP-запрос POST с телом запроса в формате JSON
}
