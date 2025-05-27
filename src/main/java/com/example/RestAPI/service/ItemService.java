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
}
