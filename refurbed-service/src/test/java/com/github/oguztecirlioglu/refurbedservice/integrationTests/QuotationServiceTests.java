package com.github.oguztecirlioglu.refurbedservice.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.Quotation;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.PhoneDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import com.github.oguztecirlioglu.refurbedservice.service.QuotationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@SpringBootTest
@AutoConfigureMockMvc
public class QuotationServiceTests {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    QuotationService quotationService;

    @Autowired
    PhoneService phoneService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        Phone phone = new Phone("2020", 1200F, "iPhone 12", PhoneManufacturer.APPLE, 64, "Blue");
        String requestBodyJson = objectMapper.writeValueAsString(phone);

        mockMvc.perform(MockMvcRequestBuilders.post("/product/phone").with(csrf())
                        .with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void generates_quote_for_phone() throws Exception {
        PhoneDetailsDTO phoneDetailsDTO = new PhoneDetailsDTO(ProductType.PHONE, 0.8F, "2020", PhoneManufacturer.APPLE, 64, "Blue" );
        Phone phone = phoneService.getPhoneByAllFields(phoneDetailsDTO);

        Quotation quotation = quotationService.generateQuote(phoneDetailsDTO);
        // check quote is correct.
    }

    @Test
    void generates_quote_for_computer() throws Exception {

    }


}
