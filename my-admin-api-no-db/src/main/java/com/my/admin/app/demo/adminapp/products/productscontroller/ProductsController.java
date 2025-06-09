package com.my.admin.app.demo.adminapp.products.productscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.admin.app.demo.adminapp.products.productsjpa.Products;
import com.my.admin.app.demo.adminapp.products.productsservice.ProductsService;
import com.my.admin.app.demo.adminapp.webmodel.UpdateProductRequest;

import jakarta.validation.Valid;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @PutMapping("/products")
    Products updateProduct(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
        return productsService.updateProduct(updateProductRequest.getUserName(), updateProductRequest);
    }

    @GetMapping("/products")
    List<Products> getProducts() {
        return productsService.findAll();
    }

}
