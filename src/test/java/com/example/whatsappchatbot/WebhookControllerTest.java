package com.example.whatsappchatbot;

import com.example.whatsappchatbot.controller.WebhookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WebhookControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new WebhookController()).build();
    }

    @Test
    void hiReturnsHello() throws Exception {
        mockMvc.perform(post("/webhook")
                        .contentType("application/json")
                        .content("{\"from\":\"+1\",\"message\":\"Hi\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("Hello"));
    }

    @Test
    void byeReturnsGoodbye() throws Exception {
        mockMvc.perform(post("/webhook")
                        .contentType("application/json")
                        .content("{\"from\":\"+1\",\"message\":\"Bye\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("Goodbye"));
    }

    @Test
    void unknownReturnsIDontUnderstand() throws Exception {
        mockMvc.perform(post("/webhook")
                        .contentType("application/json")
                        .content("{\"from\":\"+1\",\"message\":\"Whats up\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reply").value("I don't understand"));
    }
}