package com.example.RestAPI.service;

import com.example.RestAPI.model.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    //サンプルデータ
    private List<Item> allItems = Arrays.asList(
            new Item("1001", "ネックレス", "ジュエリー"),
            new Item("1002", "パーカー", "ファッション"),
            new Item("1003", "フェイスクリーム", "ビューティ"),
            new Item("1004", "サプリメント", "ヘルス"),
            new Item("1005", "ブルーベリー", "フード")
    );

    public List<Item> getAllItems() {
        return allItems;
    }

    public Item getItem(String itemId) {
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemId().equals(itemId)) {
                return allItems.get(i);
            }
        }
        return null;
    }
}
