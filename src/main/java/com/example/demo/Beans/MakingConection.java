package com.example.demo.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Conection;

@Component
public class MakingConection {
	@Bean(name="beanConection")
	public Conection getConection() {
		Conection conection = new Conection();
		conection.setDb("mysql");
		conection.setUrl("localhost");;
		return conection;
	}
}
