package com.github.oguztecirlioglu.refurbedservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="product_type")
public abstract class Product {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "manufacture_year")
    private String manufactureYear;

    @Getter
    @Setter
    private Float price;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(name = "thumbnail_url")
    private URL thumbnailURL;

}
