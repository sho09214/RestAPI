package com.example.RestAPI.controller;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> allItems = service.getAllItems();
        return allItems;
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable("itemId") String itemId) {
        return service.getItem(itemId);
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        service.addItem(item);
    }
}
