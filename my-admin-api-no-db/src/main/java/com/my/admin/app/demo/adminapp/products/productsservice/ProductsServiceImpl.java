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
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }

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

    // Example: Call two APIs asynchronously and combine their results
    // Requires: import java.util.concurrent.CompletableFuture;

    // public CompletableFuture<String> callTwoApisAsync(String url1, String url2) {
    // CompletableFuture<String> api1Future = CompletableFuture.supplyAsync(() ->
    // callExternalApiWithRestTemplate(url1));
    // CompletableFuture<String> api2Future = CompletableFuture.supplyAsync(() ->
    // callExternalApiWithRestTemplate(url2));

    // return api1Future.thenCombine(api2Future, (result1, result2) -> {
    // // Combine the results as needed
    // return "API1: " + result1 + ", API2: " + result2;
    // });
    // }
    // Requires: import reactor.core.publisher.Flux; import
    // reactor.core.publisher.Mono;

    // public String callExternalApiWithRestTemplate(String url) {
    // RestTemplate restTemplate = new RestTemplate();
    // ResponseEntity<String> response = restTemplate.getForEntity(url,
    // String.class);
    // return response.getBody();
    // }

    // .callExternalApiWithWebClientNonBlocking("https://api.example.com")
    // .subscribe(response -> {
    // // Handle the response here
    // System.out.println("API Response: " + response);
    // });
    // Non-blocking example using WebClient (returns Mono<String>)
    // public reactor.core.publisher.Mono<String>
    // callExternalApiWithWebClientNonBlocking(String url) {
    // WebClient webClient = WebClient.create();
    // return webClient.get()
    // .uri(url)
    // .retrieve()
    // .bodyToMono(String.class);
    // }

    // Blocking example using WebClient (waits for response)
    // public String callExternalApiWithWebClient(String url) {
    // WebClient webClient = WebClient.create();
    // return webClient.get()
    // .uri(url)
    // .retrieve()
    // .bodyToMono(String.class)
    // .block();
    // }
}
