package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ComputerService {

    @Autowired
    ComputerRepository computerRepository;

    public Collection<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer addNewComputer(Computer newComputer) {
        return computerRepository.save(newComputer);
    }
}
