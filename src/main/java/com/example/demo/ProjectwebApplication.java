package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.Conection;

@SpringBootApplication
public class ProjectwebApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConection")
	private Conection conection;

	public static void main(String[] args) {
		SpringApplication.run(ProjectwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print(conection.getDb());
		
	}

}
