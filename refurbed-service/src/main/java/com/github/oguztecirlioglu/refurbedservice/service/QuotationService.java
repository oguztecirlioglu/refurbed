package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.Quotation;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.ComputerDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.PhoneDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import org.springframework.beans.factory.annotation.Autowired;

public class QuotationService {

    @Autowired
    ComputerService computerService;

    @Autowired
    PhoneService phoneService;

    public Quotation generateQuote(PhoneDetailsDTO phoneDetailsDTO) throws Exception {
        if (phoneDetailsDTO.getProductType() != ProductType.PHONE)
            throw new Exception("Unmatched Product Type, expected PHONE but got: " + phoneDetailsDTO.getProductType());

        Phone actualPhone = phoneService.getPhoneByAllFields(phoneDetailsDTO);
        Float price = actualPhone.getPrice() * phoneDetailsDTO.getCondition();

        return new Quotation(price, phoneDetailsDTO.getProductType(), actualPhone, true, false);
    }

    public Quotation generateQuote(ComputerDetailsDTO computerDetailsDTO) throws Exception {
        if (computerDetailsDTO.getProductType() != ProductType.COMPUTER)
            throw new Exception("Unmatched Product Type, expected COMPUTER but got: " + computerDetailsDTO.getProductType());

        Computer actualComputer = computerService.getComputerByAllFields(computerDetailsDTO);
        Float price = actualComputer.getPrice() * computerDetailsDTO.getCondition();

        return new Quotation(price,
                computerDetailsDTO.getProductType(),
                actualComputer,
                true,
                false);
    }
}
