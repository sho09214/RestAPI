package com.example.RestAPI.controller;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable("itemId") int itemId){
        return service.getItem(itemId);
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @PutMapping("/items/{itemId}")
    public void updateItem(@PathVariable("itemId") int itemId,
                           @RequestBody Item item) {
        service.updateItem(itemId, item);
    }
}
