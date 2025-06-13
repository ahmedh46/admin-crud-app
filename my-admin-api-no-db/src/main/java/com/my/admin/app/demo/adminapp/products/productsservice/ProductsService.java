package com.my.admin.app.demo.adminapp.products.productsservice;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

import com.my.admin.app.demo.adminapp.products.productsjpa.Products;
import com.my.admin.app.demo.adminapp.products.productsjpa.ProductsRepository;
import com.my.admin.app.demo.adminapp.users.usersjpa.Users;
import com.my.admin.app.demo.adminapp.users.usersjpa.UsersRepository;
import com.my.admin.app.demo.adminapp.webmodel.UpdateProductRequest;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;

    public ProductsService(ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }

    // @Autowired
    // ProductsRepository productsRepository;

    // @Autowired
    // UsersRepository usersRepository;

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
        Products product1 = new Products();
        
        product1.setName("Mock Product 1");
        product1.setDescription("Description for Mock Product 1");
       

        Products product2 = new Products();
       
        product2.setName("Mock Product 2");
        product2.setDescription("Description for Mock Product 2");
       

        return List.of(product1, product2);
       // return (List<Products>) productsRepository.findAll();
    }
}
