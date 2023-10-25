package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository <Model, UUID> {

    @Query(value = "SELECT m FROM Model AS m INNER JOIN Brand as b ON b.id = m.brand.id WHERE b.name = :brand_name")
    List<Model> findNameAndCategoryBOrderByBrand(String brand_name);

    List<Model> findAllByBrandName(String brand_name);//Этот метод использует пользовательский запрос для получения списка объектов модели на основе названия бренда.
}
