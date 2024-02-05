package com.github.oguztecirlioglu.refurbedservice.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.oguztecirlioglu.refurbedservice.controller.FunnelController;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.service.FunnelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = FunnelController.class)
public class FunnelControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FunnelService funnelService;

    @Test
    @WithMockUser
    void product_type_returns_valid_values_with_go() throws Exception {
        Mockito.when(funnelService.getProductTypes()).thenReturn(Arrays.asList(ProductType.values()));

        ResultActions ra = mockMvc.perform(get("/funnelService/productType"));

        for(ProductType productType : ProductType.values()) {
            ra.andExpect(content().string(containsString(productType.toString())));
        }

        Mockito.verify(funnelService, Mockito.times(1)).getProductTypes();
    }




}
