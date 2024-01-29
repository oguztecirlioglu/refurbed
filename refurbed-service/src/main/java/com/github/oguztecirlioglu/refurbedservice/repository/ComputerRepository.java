package com.github.oguztecirlioglu.refurbedservice.repository;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import org.springframework.data.repository.CrudRepository;

interface ComputerRepository extends CrudRepository<Computer, Long> {
}
