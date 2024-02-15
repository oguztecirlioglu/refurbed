package com.github.oguztecirlioglu.refurbedservice.integrationTests;

import com.github.oguztecirlioglu.refurbedservice.service.QuotationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
//@SqlGroup({
//        @Sql(value = "classpath:empty/reset.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
//        @Sql(value = "classpath:product-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//})
public class QuotationServiceTests {

    @Autowired
    QuotationService quotationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_create_one_user() throws Exception {

    }


}
