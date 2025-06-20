package com.jyx.medialibrary.dbstarter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBLoader {
	
	@Bean
	   public CommandLineRunner initDatabase() {
	      return args -> {
	         System.out.println("Hello World!");
	      };
	   }


}
