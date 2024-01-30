package com.github.oguztecirlioglu.refurbedservice.repository;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
