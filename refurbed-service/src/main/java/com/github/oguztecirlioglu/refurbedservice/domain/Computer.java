package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Product {

    @Getter
    @Setter
    private ComputerManufacturer computerManufacturer;

    @Getter
    @Setter
    private Short storage;

    @Getter
    @Setter
    private Float screenSize;

}
