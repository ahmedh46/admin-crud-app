package com.my.admin.app.demo.adminapp.webmodel;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {

    @NotNull
    private String userName;

    @NotNull
    private String productName;

    @NotNull
    private String productDescription;

    @NotNull
    private BigDecimal productPrice;

}
