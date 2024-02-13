package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.ComputerDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import com.github.oguztecirlioglu.refurbedservice.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ComputerService {

    @Autowired
    ComputerRepository computerRepository;

    public Collection<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer addNewComputer(Computer newComputer) {
        return computerRepository.save(newComputer);
    }

    public Computer getComputerByAllFields(ComputerDetailsDTO computerDetailsDTO) {
        return computerRepository.findByComputerManufacturerAndScreenSizeAndStorageAndManufactureYear(
                computerDetailsDTO.getComputerManufacturer(),
                computerDetailsDTO.getScreenSize(),
                computerDetailsDTO.getStorage(),
                computerDetailsDTO.getManufactureYear()
        );
    }
}
