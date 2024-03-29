package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.service.ComputerService;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import jakarta.validation.Valid;
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

    // These are private methods - NO client request should ever hit these.
    // A limited set Phones and Computers will be used to generate Quotes, in a many-to-one relationship.
    // Add admin role to execute these methods in the future.
    @PostMapping("/phone")
    Phone addNewPhone(@Valid @RequestBody Phone phone) {
        return phoneService.addNewPhone(phone);
    }

    @PostMapping("/computer")
    Computer addNewComputer(@Valid @RequestBody Computer computer) {
        return computerService.addNewComputer(computer);
    }
}
