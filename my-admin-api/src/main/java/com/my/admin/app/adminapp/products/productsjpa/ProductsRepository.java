package com.my.admin.app.adminapp.products.productsjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

    Products findByName(String name);
}