package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NonNull
@AllArgsConstructor
public class Phone extends Product {

    @Setter
    @Getter
    @NonNull
    private PhoneManufacturer phoneManufacturer;

    @Setter
    @Getter
    @NonNull
    private Short memory;

    @Setter
    @Getter
    @NonNull
    private String color;
}
