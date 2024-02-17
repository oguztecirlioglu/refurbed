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
    private Integer storage;

    @Getter
    @Setter
    @NotNull
    private Float screenSize;

   public Computer(String manufactureYear, Float price, String name, ComputerManufacturer computerManufacturer, Integer storage, Float screenSize) {
      super(manufactureYear, price, name);
      this.computerManufacturer = computerManufacturer;
      this.storage = storage;
      this.screenSize = screenSize;
   }

   public Computer(ComputerManufacturer computerManufacturer,
                   Float screenSize, Integer storage,
                   String manufactureYear) {
               this.computerManufacturer = computerManufacturer;
               this.screenSize = screenSize;
               this.storage = storage;
               this.setManufactureYear(manufactureYear);
   }
}
