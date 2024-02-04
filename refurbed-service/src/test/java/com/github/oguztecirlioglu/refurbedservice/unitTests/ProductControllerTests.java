package com.github.oguztecirlioglu.refurbedservice.unitTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.oguztecirlioglu.refurbedservice.controller.ProductController;
import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import com.github.oguztecirlioglu.refurbedservice.service.ComputerService;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    PhoneService phoneService;

    @MockBean
    ComputerService computerService;


    @Test
    void throws_error_malformed_json_addPhone() throws Exception {
        String malformedJson = "{\"invalidField\":\"value\"}";
        mockMvc.perform(post("/product/phone")
                        .with(csrf()).with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(malformedJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void throws_error_malformed_json_addComputer() throws Exception {
        String malformedJson = "{\"invalidField\":\"value\"}";
        mockMvc.perform(post("/product/computer")
                        .with(csrf())
                        .with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(malformedJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void throws_403_on_unathorised_user_making_post_request() throws Exception {
        mockMvc.perform(post("/product/computer").contentType(MediaType.APPLICATION_JSON).content("")).andExpect(status().isForbidden());
        mockMvc.perform(post("/product/phone").contentType(MediaType.APPLICATION_JSON).content("")).andExpect(status().isForbidden());
    }

    @Test
    void calls_service_layer_for_phone_on_expected_json() throws Exception {
        String manufactureYear = "2012";
        Float price = 1129.5F;
        String name = "iPhone";
        String description = "iPhone Description";
        URL url = new URL("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-card-40-iphone15prohero-202309_FMT_WHH?wid=508&hei=472&fmt=p-jpg&qlt=95&.v=1693086369818");
        PhoneManufacturer phoneManufacturer = PhoneManufacturer.APPLE;
        Short memory = 256;
        String color = "blue";

        Phone samplePhone = new Phone(manufactureYear, price, name, description, url, phoneManufacturer, memory, color);
        String requestBodyJson = objectMapper.writeValueAsString(samplePhone);

        mockMvc.perform(post("/product/phone")
                        .with(csrf()).with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyJson))
                .andExpect(status().isOk());

        Mockito.verify(phoneService, Mockito.times(1)).addNewPhone(any(Phone.class));
    }


    @Test
    void calls_service_layer_for_computer_on_expected_json() throws Exception {
        String manufactureYear = "2021";
        Float price = 3000F;
        String name = "Macbook Pro";
        String description = "Some Description";
        URL url = new URL("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/og-macbook-pro-202310?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1697039356093");

        ComputerManufacturer computerManufacturer = ComputerManufacturer.APPLE;
        Short storage = 1024;
        Float screenSize = 15.8F;

        Computer sampleComputer = new Computer(manufactureYear, price, name, description, url, computerManufacturer, storage, screenSize);
        String requestBodyJson = objectMapper.writeValueAsString(sampleComputer);

        mockMvc.perform(post("/product/computer")
                        .with(csrf()).with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyJson))
                .andExpect(status().isOk());

        Mockito.verify(computerService, Mockito.times(1)).addNewComputer(any(Computer.class));
    }
}