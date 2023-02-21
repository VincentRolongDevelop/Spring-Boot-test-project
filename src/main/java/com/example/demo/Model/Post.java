package com.example.demo.Model;

public class Post {
	private int id;
	private String desciption;
	private String urImg = "http://localhost:8080/image/update.jpg";
	private String title;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getUrImg() {
		return urImg;
	}
	public void setUrImg(String urImg) {
		this.urImg = urImg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Post(int id, String desciption, String urImg, String title) {
		
		this.id = id;
		this.desciption = desciption;
		this.urImg = urImg;
		this.title = title;
	}
	public Post() {
		
	}	
}
