package com.example.RestAPI.service;

import com.example.RestAPI.exception.ItemNotFoundException;
import com.example.RestAPI.model.Item;
import com.example.RestAPI.repository.ItemRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
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

//    private List<Item> allItems = new ArrayList<>(Arrays.asList(
//       new Item("ネックレス", "ジュエリー"),
//       new Item( "パーカー", "ライトアウター"),
//       new Item("サプリメント", "ヘルスケア")
//    ));

    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();
        repository.findAll().forEach(item -> allItems.add(item));

        return allItems;
    }

    public Optional<Item> getItem(long id){
        return repository.findById(id);
    }

    public void addItem(Item item){
        repository.save(item);
    }

    public void  updateItem(long id, Item item) {
        //existsByIDがtrueで返ってくるレコードがあれば、save()する
        if(!repository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
            item.setId(id);
            repository.save(item);
    }

    public void deleteItem(long id){
        repository.deleteById(id);
    }
}
