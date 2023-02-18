package com.example.demo.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Post;

import org.springframework.web.bind.annotation.GetMapping;

//Annotation for controller
@Controller

//A folder or route with more sub-routes
@RequestMapping("/home")
public class Basic_controller {
	
	public List<Post> getPosts(){
	ArrayList<Post> post = new ArrayList<>();
		
		post.add(new Post(1,"The POST submits an entity to the specified resource.","http://localhost:8080/image/post.jpg","POST"));
		post.add(new Post(2,"The GET is applied while requesting information.","http://localhost:8080/image/get.jpg","GET"));
		post.add(new Post(3,"The PUT is used to send data to a server to create data.","http://localhost:8080/image/put.jpg","PUT"));
		post.add(new Post(4,"The UPDATE method is used to modify the existing data.","http://localhost:8080/image/update.jpg","UPDATE"));
		
		return post;
	}

	@GetMapping(path={"/post","/"})
	public String saludar(Model model) {
		model.addAttribute("posts",this.getPosts());
		return "index";
	}
	
	@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView("Page.HOME");
		modelAndView .addObject("posts",this.getPosts());
		return modelAndView; 
	}
}
