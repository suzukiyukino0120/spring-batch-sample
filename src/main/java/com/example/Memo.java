package com.example;

public class Memo {
	
	private Integer id;
	
	private String content;
	
	public Memo(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + "]";
	}
	
	

}
