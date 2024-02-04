package com.github.oguztecirlioglu.refurbedservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
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

    public Product(String manufactureYear, Float price, String name, String description, URL thumbnailURL) {
        this.manufactureYear = manufactureYear;
        this.price = price;
        this.name = name;
        this.description = description;
        this.thumbnailURL = thumbnailURL;
    }
}
