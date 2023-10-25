package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;//для доступа к базе данных  для выполнения операций CRUD
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {//базовые методы для работы с сущностью Brand

}//доступ к данным сущности Brand.
