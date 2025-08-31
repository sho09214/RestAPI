package com.example.RestAPI.controller;

import com.example.RestAPI.exception.ItemNofFoundException;
import com.example.RestAPI.model.Item;
import com.example.RestAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return service.getItem(itemId).orElseThrow(() -> new ItemNofFoundException(itemId));
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        service.addItem(item);
    }

    @PutMapping("/items/{itemId}")
    public void updateItem(@RequestBody Item item,
                           @PathVariable("itemId") Long itemId) {
        service.updateItem(itemId, item);
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        service.deleteItem(itemId);
    }
}
