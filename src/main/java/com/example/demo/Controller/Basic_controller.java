package com.example.demo.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Post;

import configuration.Page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping(path={"/posts","/"})
	public String saludar(Model model) {
		model.addAttribute("posts",this.getPosts());
		return "index";
	}
	
	
	//ModelAndView
	/*
	@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Page.HOME);
		modelAndView .addObject("posts",this.getPosts());
		return modelAndView; 
	}
	*/
	
	@GetMapping(path={"/post"})
	public ModelAndView getPostIndi(
			@RequestParam(defaultValue="1",name="id",required=false)int id
			) {
		ModelAndView modelAndView = new ModelAndView(Page.POST);
		
		List<Post> postFil = this.getPosts().stream()
				.filter( (p)->{
				   return p.getId()==id;
				}).collect(Collectors.toList());
		
		modelAndView.addObject("post",postFil.get(0));		
		return modelAndView;		
	}		
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post",new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts=this.getPosts();
		posts.add(post);
		model.addAttribute("posts",posts);
		return "index";
		
	}
}
