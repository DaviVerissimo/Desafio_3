package com.compass.uol.davi.desafio3.exceptions;

@SuppressWarnings("serial")
public class PostNotFoundException extends Exception{
	
	@Override
	public String getMessage() {
		return "Post not found";
	}
}
