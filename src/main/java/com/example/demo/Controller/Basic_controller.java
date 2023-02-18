package com.example.demo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

//Annotation for controller
@Controller

//A folder or route with more sub-routes
@RequestMapping("/hola")


public class Basic_controller {

	@GetMapping(path={"/saludar","/holamundo"})
	public String saludar() {
		return "index";
	}
}
