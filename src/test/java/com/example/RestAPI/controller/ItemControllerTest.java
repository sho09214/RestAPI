package com.example.RestAPI.controller;

import com.example.RestAPI.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllItems() {
    }

    @Test
    void getItem() throws Exception {
        int itemId = 1;
        String responseJsonString = mvc.perform(get("/items/{itemId}", itemId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //取得したJson→Itemに変換
        ObjectMapper objectMapper = new ObjectMapper();
        Item responseItem = objectMapper.readValue(responseJsonString, Item.class);

        //各値を比較する
        assertThat(responseItem.getId()).isEqualTo(itemId);
        assertThat(responseItem.getName()).isEqualTo("ネックレス");
        assertThat(responseItem.getCategory()).isEqualTo("ジュエリ");
    }

    @Test
    void addItem() {
    }

    @Test
    void updateItem() {
    }

    @Test
    void deleteItem() {
    }
}