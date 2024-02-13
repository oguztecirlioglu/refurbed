package com.github.oguztecirlioglu.refurbedservice.repository;

import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Phone findByPhoneManufacturerAndMemoryAndColorAndManufactureYear(PhoneManufacturer phoneManufacturer,
                                                                     Short memory,
                                                                     String color,
                                                                     String manufactureYear);
}
