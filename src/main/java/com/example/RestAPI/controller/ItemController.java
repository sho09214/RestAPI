package com.example.RestAPI.controller;

import com.example.RestAPI.exception.ItemNotFoundException;
import com.example.RestAPI.model.Item;
import com.example.RestAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable("itemId") long itemId) {
        return service.getItem(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @PutMapping("/items/{itemId}")
    public void updateItem(@PathVariable("itemId") long itemId,
                           @RequestBody Item item) {
        service.updateItem(itemId, item);
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable("itemId") long itemId){
        service.deleteItem(itemId);
    }
}
