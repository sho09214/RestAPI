package com.example.RestAPI.controller;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return service.getAllItems();
    }
}
