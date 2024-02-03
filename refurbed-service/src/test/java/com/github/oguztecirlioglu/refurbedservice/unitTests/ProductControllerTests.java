package com.github.oguztecirlioglu.refurbedservice.unitTests;


import com.github.oguztecirlioglu.refurbedservice.controller.ProductController;
import com.github.oguztecirlioglu.refurbedservice.service.ComputerService;
import com.github.oguztecirlioglu.refurbedservice.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

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
    void calls_service_layer_for_phone_on_expected_json() {

    }


    @Test
    void calls_service_layer_for_computer_on_expected_json() {
    }


    @Test
    void phoneExists() {
    }

    @Test
    void computerExists() {
    }


    @Test
    void bothExist() {
    }
}