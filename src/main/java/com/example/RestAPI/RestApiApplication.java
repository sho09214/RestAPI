package com.example.RestAPI;

import com.example.RestAPI.model.Item;
import com.example.RestAPI.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestApiApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(RestApiApplication.class);
	}

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
