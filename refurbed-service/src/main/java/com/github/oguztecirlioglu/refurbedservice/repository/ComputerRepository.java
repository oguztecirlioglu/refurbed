package com.github.oguztecirlioglu.refurbedservice.repository;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    Computer findByComputerManufacturerAndScreenSizeAndStorageAndManufactureYear(ComputerManufacturer computerManufacturer,
                                                                                 Float screenSize,
                                                                                 Short storage,
                                                                                 String manufactureYear);
}
