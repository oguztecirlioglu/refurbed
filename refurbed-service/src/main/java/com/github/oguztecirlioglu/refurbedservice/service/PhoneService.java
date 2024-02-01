package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Collection<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone addNewPhone(Phone newPhone) {
        return phoneRepository.save(newPhone);
    }
}
