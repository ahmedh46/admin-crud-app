package com.my.admin.app.demo.adminapp.products.productsservice;

import java.util.List;

import com.my.admin.app.demo.adminapp.products.productsjpa.Products;
import com.my.admin.app.demo.adminapp.webmodel.UpdateProductRequest;

public interface ProductsService {
    Products updateProduct(String userName, UpdateProductRequest updateProductRequest);

    List<Products> findAll();
}
