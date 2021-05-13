package com.ashok.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorMessage implements Serializable{
	
	private String message;
	
	private String time;
	
	private String url;
	

	public ErrorMessage() {
		
	}

	public ErrorMessage(String message, String time, String url) {
		super();
		this.message = message;
		this.time = time;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
