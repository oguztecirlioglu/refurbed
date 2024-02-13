package com.github.oguztecirlioglu.refurbedservice.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.oguztecirlioglu.refurbedservice.controller.FunnelController;
import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.ProductTypeDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import com.github.oguztecirlioglu.refurbedservice.service.FunnelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void product_type_returns_valid_values_with() throws Exception {
        Mockito.when(funnelService.getProductTypes()).thenReturn(Arrays.asList(ProductType.values()));

        ResultActions ra = mockMvc.perform(get("/funnelService/productType"));

        for (ProductType productType : ProductType.values()) {
            ra.andExpect(content().string(containsString(productType.toString())));
        }

        Mockito.verify(funnelService, Mockito.times(1)).getProductTypes();
    }

    @Test
    void model_request_returns_valid_product_for_computer() throws Exception {
        URL myURL = new URL("http://example.com/pages/");
        ProductTypeDTO computerProductTypeDTO = new ProductTypeDTO(ProductType.COMPUTER);

        List<Product> mockComputers = Arrays.asList(
                new Computer("2020", 1110F,
                        "MacBook", ComputerManufacturer.APPLE,
                        (short) 1024, 15.9F),

                new Computer("2022", 1110F,
                        "Notebook", ComputerManufacturer.MICROSOFT,
                        (short) 2048, 15.9F)
        );

        Mockito.when(funnelService.getComputers()).thenReturn(mockComputers);

        MvcResult result = mockMvc.perform(post("/funnelService/model")
                        .with(csrf())
                        .with(user("user").roles("USER"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(computerProductTypeDTO)))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void model_request_returns_valid_product_for_phone() {

    }


}
