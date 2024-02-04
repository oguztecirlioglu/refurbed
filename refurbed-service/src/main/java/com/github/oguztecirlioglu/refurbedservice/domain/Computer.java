package com.github.oguztecirlioglu.refurbedservice.domain;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity
@NoArgsConstructor
 public class Computer extends Product {

    @Getter
    @Setter
    @NotNull
    private ComputerManufacturer computerManufacturer;

    @Getter
    @Setter
    @NotNull
    private Short storage;

    @Getter
    @Setter
    @NotNull
    private Float screenSize;

   public Computer(String manufactureYear, Float price, String name, String description, URL thumbnailURL, ComputerManufacturer computerManufacturer, Short storage, Float screenSize) {
      super(manufactureYear, price, name, description, thumbnailURL);
      this.computerManufacturer = computerManufacturer;
      this.storage = storage;
      this.screenSize = screenSize;
   }
}
