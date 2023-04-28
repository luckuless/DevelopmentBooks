package com.kata.DevelopmentBooks.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.DevelopmentBooks.TestUtils;
import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.repository.BookRepository;
import com.kata.DevelopmentBooks.service.IBasketService;

@WebMvcTest(controllers = BasketController.class)
@ExtendWith(MockitoExtension.class)
public class BasketControllerTest {


    @MockBean
    private IBasketService basketService;

    @Autowired
    private MockMvc mockMvc;
  
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * @throws Exception
     * @throws JsonProcessingException
     * 
     */
    @Test
    void whenValidInput_thenReturns200() throws JsonProcessingException, Exception {
        Basket basket = new Basket();

       given(basketService.getBasketWithPrice(basket)).willReturn(TestUtils.createBasket_withPrice());
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/1.0/basket/calculate-price")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(basket)))
        .andExpect(status().isOk());
    }

    @Test
    void whenNoInput_thenReturns400() throws JsonProcessingException, Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/1.0/basket/calculate-price")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
    }

    @Test
    @Disabled
    void whenBookNotFound_thenThrowException() throws JsonProcessingException, Exception {
        Basket basket = TestUtils.createBasket();

        when(basketService.getBasketWithPrice(any())).thenThrow();
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/1.0/basket/calculate-price")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(basket)))
        .andExpect(status().isNotFound());
    }
    
}   
