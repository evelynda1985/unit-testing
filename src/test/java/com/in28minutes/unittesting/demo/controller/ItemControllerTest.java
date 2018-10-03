package com.in28minutes.unittesting.demo.controller;

import com.in28minutes.unittesting.demo.business.Item;
import com.in28minutes.unittesting.demo.business.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception{
        //Call get "/dummy-item" and the response should be in JSON
        RequestBuilder request = MockMvcRequestBuilders
                                    .get("/dummy-item")
                                    .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                                    .andExpect(status().isOk())
                                    .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                                    .andReturn();

        //Verify Hello World
        //assertEquals("Hello World", result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinsessService_basic() throws Exception{
        when(businessService.retrieveHardCodeItem()).thenReturn(new Item(2, "Item2", 10, 10));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name:Item2, price:10, quantity:10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception{
        when(businessService.retrieveAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10),
                                                                    (new Item(3, "Item3", 20, 20)))
                                                                    );
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                /*.andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10}," +
                                                        "{id:3, name:Item3, price:20, quantity:20}"+
                                                        "]"))*/
                .andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10}," +
                        "{}"+
                        "]"))//I just want to check the first item
                .andReturn();
    }

}
