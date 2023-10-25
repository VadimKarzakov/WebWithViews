package com.example.springdatabasicdemo.config;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.constants.Category;
import com.example.springdatabasicdemo.constants.Engine;
import com.example.springdatabasicdemo.constants.Role;
import com.example.springdatabasicdemo.constants.Transmission;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component //создавать экземпляры Spring framework.
public class Data implements CommandLineRunner {// интерфейс `CommandLineRunner`

    @Autowired
    private final UserRoleService userRoleService;
    @Autowired
    private final ModelService modelService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final BrandService brandService;
    @Autowired
    private final OfferService offerService;
//подключаемые зависимости
    public Data(
            UserRoleService userRoleService,
            ModelService modelService,
            UserService userService,
            BrandService brandService,
            OfferService offerService
    ) {
        this.userRoleService = userRoleService;
        this.modelService = modelService;
        this.userService = userService;
        this.brandService = brandService;
        this.offerService = offerService;
    }


    @Override
    public void run(String... args) throws Exception {//заполнения базы данных исходными данными
        seedData();
    }


    private void seedData() throws IOException {//Метод `seedData` создает и сохраняет экземпляры различных классов DTO

        UserRoleDto role = new UserRoleDto(
                Role.ADMIN
        );
        role = userRoleService.create(role);

        UserDto user = new UserDto(
                "OlegTheBoss",
                "qwerty",
                "Oleg",
                "Sokolov",
                true,
                "https://source.unsplash.com/random/200x200?sig=1",
                new Date(),
                new Date(),
                role
        );
        user = userService.create(user);

        BrandDto brand = new BrandDto(
                "Chevrolet",
                new Date(),
                new Date()
        );
        brand = brandService.create(brand);

        ModelDto model = new ModelDto(
                "Orlando",
                Category.MOTORCYCLE,
                "https://source.unsplash.com/random/200x200?sig=1",
                2010,
                2011,
                new Date(),
                new Date(),
                brand
        );
        model = modelService.create(model);

        OfferDto offer = new OfferDto(
                "fast",
                Engine.GASOLIN,
                "https://source.unsplash.com/random/200x200?sig=1",
                100,
                25000,
                Transmission.AUTOMATIC,
                2010,
                new Date(),
                new Date(),
                model,
                user
        );

        System.out.println(offer);
        System.out.println(offerService.create(offer));

//        userService.destroy(user);

    }
}

