package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.service.ComputerService;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProductController {
    // Get Most Recently Posted N products
    // Get product by id

    @Autowired
    PhoneService phoneService;

    @Autowired
    ComputerService computerService;

    @GetMapping("/product/allPhones")
    Collection<Phone> allPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/product/allComputers")
    Collection<Computer> allComputers() {
        return computerService.getAllComputers();
    }

    @PostMapping("/product/phone")
    Phone addNewPhone(@RequestBody Phone phone) {
        return phoneService.addNewPhone(phone);
    }

    @PostMapping("/product/computer")
    Computer addNewComputer(@RequestBody Computer computer) {
        return computerService.addNewComputer(computer);
    }
}
