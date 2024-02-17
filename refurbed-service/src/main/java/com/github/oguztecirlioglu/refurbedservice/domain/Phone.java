package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity
@NoArgsConstructor
public class Phone extends Product {
    @Setter
    @Getter
    @NotNull
    private PhoneManufacturer phoneManufacturer;

    @Setter
    @Getter
    @NotNull
    private Integer memory;

    @Setter
    @Getter
    @NotNull
    private String color;

    public Phone(String manufactureYear, Float price, String name, PhoneManufacturer phoneManufacturer, Integer memory, String color) {
        super(manufactureYear, price, name);
        this.phoneManufacturer = phoneManufacturer;
        this.memory = memory;
        this.color = color;
    }
}
