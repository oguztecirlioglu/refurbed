package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
public class Quotation {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private Float price;

    @Getter
    @Setter
    @Column(nullable = false)
    private ProductType productType;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(nullable = false)
    private Product product;

    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean active;

    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean acceptedByCustomer;

    public Quotation(Float price, ProductType productType, Product product, Boolean active, Boolean acceptedByCustomer) {
        this.price = price;
        this.productType = productType;
        this.product = product;
        this.active = active;
        this.acceptedByCustomer = acceptedByCustomer;
    }
}
