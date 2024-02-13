package com.github.oguztecirlioglu.refurbedservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Entity
public class ProductMetaData {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;


    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(name = "thumbnail_url")
    private URL thumbnailURL;
}
