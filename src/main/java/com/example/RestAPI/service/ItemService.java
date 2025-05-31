package com.example.RestAPI.service;

import com.example.RestAPI.exception.ItemNotFoundException;
import com.example.RestAPI.model.HelloMessage;
import com.example.RestAPI.model.Item;
import com.example.RestAPI.repository.ItemRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    private RestTemplate restTemplate;

    public ItemService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

//    private List<Item> allItems = new ArrayList<>(Arrays.asList(
//       new Item("ネックレス", "ジュエリー"),
//       new Item( "パーカー", "ライトアウター"),
//       new Item("サプリメント", "ヘルスケア")
//    ));

    @Cacheable("getItems")
    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();

        //Cache動作確認用
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        repository.findAll().forEach(item -> allItems.add(item));

        return allItems;
    }

    @Cacheable(value = "getItem", key = "#p0")
    public Optional<Item> getItem(long id){
        //Cache動作確認用
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return repository.findById(id);
    }

    @CacheEvict(value = "getItems", allEntries = true)
    public void addItem(Item item){
        repository.save(item);
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#p0"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void  updateItem(long id, Item item) {
        //existsByIDがtrueで返ってくるレコードがあれば、save()する
        if(!repository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
            item.setId(id);
            repository.save(item);
    }

    @Caching(evict = {
            @CacheEvict(value = "getItem", key = "#p0"),
            @CacheEvict(value = "getItems", allEntries = true)
    })
    public void deleteItem(long id){
        repository.deleteById(id);
    }

    public HelloMessage getHelloResponse(){
        String url = "http://localhost:8080/hello";
        String hello = restTemplate.getForObject(url, String.class);

        HelloMessage retHello = new HelloMessage(hello);
        return retHello;
    }
}
