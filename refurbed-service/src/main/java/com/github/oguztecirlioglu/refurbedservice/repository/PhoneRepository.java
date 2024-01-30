package com.github.oguztecirlioglu.refurbedservice.repository;

import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
