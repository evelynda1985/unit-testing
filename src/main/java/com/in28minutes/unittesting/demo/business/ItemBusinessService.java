package com.in28minutes.unittesting.demo.business;

import com.in28minutes.unittesting.demo.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    ItemRepository repository;

    public Item retrieveHardCodeItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAll(){
        List<Item> items = repository.findAll();
        for(Item item: items){
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }
}
