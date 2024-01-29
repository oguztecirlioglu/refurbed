package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.phoneEnums.PhoneManufacturer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Phone extends Product {

    @Setter
    @Getter
    private PhoneManufacturer phoneManufacturer;

    @Setter
    @Getter
    private Short memory;

    @Setter
    @Getter
    private String color;
}