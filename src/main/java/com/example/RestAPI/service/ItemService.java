package com.example.RestAPI.service;

import com.example.RestAPI.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private List<Item> allItems = new ArrayList<>(Arrays.asList(
       new Item(1000, "ネックレス", "ジュエリー"),
       new Item(1001, "パーカー", "ライトアウター"),
       new Item(1002, "サプリメント", "ヘルスケア")
    ));

    public List<Item> getAllItems(){
        return allItems;
    }

    public Item getItem(int id){
        Item item = new Item();
        for(int i = 0; i < allItems.size(); i++){
            if(allItems.get(i).getId() == id){
                item = allItems.get(i);
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item){
        allItems.add(item);
    }

    public void  updateItem(int id, Item item) {
        for(int i = 0; i < allItems.size(); i++){
            if(allItems.get(i).getId() == id) {
                allItems.set(i, item);
            }
        }
    }
}
