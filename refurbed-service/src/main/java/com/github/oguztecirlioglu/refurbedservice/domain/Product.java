package com.github.oguztecirlioglu.refurbedservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Entity
public abstract class Product {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String year;

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
