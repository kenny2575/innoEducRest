package ru.inno.educ.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class CorporateInstanceControllerIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    void handleCreateCorporateWhenEmptyBodyReturnsBadRequest() throws Exception {
        var requestBuilder = post("/corporate-settlement-instance/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {}
                        """);

        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.errorMessage").exists()
                );
    }

}