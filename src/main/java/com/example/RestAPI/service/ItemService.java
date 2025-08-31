package com.example.RestAPI.service;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        repository.findAll().forEach(allItems::add);

        return allItems;
    }

    public Optional<Item> getItem(Long itemId) {
        return repository.findById(itemId);
    }

    public void addItem(Item item) {
        repository.save(item);
    }

    public void updateItem(Long itemId, Item item) {
        if (repository.findById(itemId).get() != null) {
            repository.save(item);
        }
    }

    public void deleteItem(Long itemId) {
        repository.deleteById(itemId);
    }
}
