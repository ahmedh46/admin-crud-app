package com.my.admin.app.adminapp.products.productsservice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.admin.app.adminapp.products.productsjpa.Products;
import com.my.admin.app.adminapp.products.productsjpa.ProductsRepository;
import com.my.admin.app.adminapp.users.usersjpa.Users;
import com.my.admin.app.adminapp.users.usersjpa.UsersRepository;
import com.my.admin.app.adminapp.webmodel.UpdateProductRequest;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UsersRepository usersRepository;

    public Products updateProduct(String userName, UpdateProductRequest updateProductRequest) {
        Users user = usersRepository.findByUserName(userName);
        Products foundProduct = productsRepository.findByName(updateProductRequest.getProductName());
        if (Objects.nonNull(foundProduct)) {
            foundProduct.setUpdatedBy(user.getUserId());
            foundProduct.setName(updateProductRequest.getProductName());
            foundProduct.setDescription(updateProductRequest.getProductDescription());
            foundProduct.setPrice(updateProductRequest.getProductPrice());
            return productsRepository.save(foundProduct);
        }

        return null;
    }

    public List<Products> findAll() {
        return (List<Products>) productsRepository.findAll();
    }
}
