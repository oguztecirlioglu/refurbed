package com.github.oguztecirlioglu.refurbedservice.domain;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

public abstract class Product {
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
