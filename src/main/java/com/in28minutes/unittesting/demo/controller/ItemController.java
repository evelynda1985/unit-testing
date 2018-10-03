package com.in28minutes.unittesting.demo.controller;

import com.in28minutes.unittesting.demo.business.Item;
import com.in28minutes.unittesting.demo.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardCodeItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return businessService.retrieveAll();
    }
}
