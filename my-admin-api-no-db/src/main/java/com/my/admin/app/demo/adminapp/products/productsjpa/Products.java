package com.my.admin.app.demo.adminapp.products.productsjpa;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {

    @Id
    private long productId;

    private String name;

    private BigDecimal price;

    private String description;

    private Timestamp createdDate;

    private long updatedBy;
}
