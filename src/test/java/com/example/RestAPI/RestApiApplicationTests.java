package com.example.RestAPI;

import com.example.RestAPI.controller.ItemController;
import com.example.RestAPI.repository.ItemRepository;
import com.example.RestAPI.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ItemController controller;

	@Autowired
	private ItemService service;

	@Autowired
	private ItemRepository repository;

	//アプリケーションがSpringコンテキストを正常にロードできたかどうかを検証する
	@Test
	void contextLoads() {
		//AssertJを利用した検証を実装する
		//assertThatの引数に検証の値をいれる
		//続けてメソッドにて期待値を指定。この場合はNullでないこと
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
		assertThat(repository).isNotNull();
    }

}
