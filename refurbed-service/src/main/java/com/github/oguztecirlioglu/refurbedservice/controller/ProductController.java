package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.service.ComputerService;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {
    // Get Most Recently Posted N products
    // Get product by id

    @Autowired
    PhoneService phoneService;

    @Autowired
    ComputerService computerService;

    @GetMapping("/all")
    Collection<Product> allProducts() {
        return new ArrayList<Product>();
    }

    @GetMapping("/allPhones")
    Collection<Phone> allPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/allComputers")
    Collection<Computer> allComputers() {
        return computerService.getAllComputers();
    }

    @PostMapping("/phone")
    Phone addNewPhone(@RequestBody Phone phone) {
        return phoneService.addNewPhone(phone);
    }

    @PostMapping("/computer")
    Computer addNewComputer(@RequestBody Computer computer) {
        return computerService.addNewComputer(computer);
    }
}
