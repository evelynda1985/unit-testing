package com.in28minutes.unittesting.demo.service;

import com.in28minutes.unittesting.demo.business.Item;
import com.in28minutes.unittesting.demo.business.ItemBusinessService;
import com.in28minutes.unittesting.demo.data.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService businessService;

    @Mock
    private ItemRepository repositoryMock;

    @Test
    public void retrieveAllTest(){
        when(repositoryMock.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10),
                                                        (new Item(3, "Item3", 20, 20)))
                                                        );
        List<Item> items = businessService.retrieveAll();
        assertEquals(100, items.get(0).getValue() );
        assertEquals(400, items.get(1).getValue());
    }

}
