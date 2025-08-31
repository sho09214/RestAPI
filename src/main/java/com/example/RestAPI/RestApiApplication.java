package com.example.RestAPI;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Item("ネックレス", "ジュエリ"));
		repository.save(new Item("パーカー", "ファッション"));
		repository.save(new Item("フェイスクリーム", "ビューティ"));
		repository.save(new Item("サプリメント", "ヘルス"));
		repository.save(new Item("ブルーベリー", "フード"));
	}
}
