package com.nie.csd.controllersTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.nie.csd.controllers.ProductController;

@WebMvcTest(ProductController.class)
public class ProductControllerTestClass {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void testSayHello()throws Exception{
        mockMvc.perform(get("/hello1"))
        .andExpect(status().isOk())
        .andExpect(content().string("HELLO"));
    }

}