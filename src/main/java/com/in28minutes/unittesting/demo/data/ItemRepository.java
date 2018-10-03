package com.in28minutes.unittesting.demo.data;

import com.in28minutes.unittesting.demo.business.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
