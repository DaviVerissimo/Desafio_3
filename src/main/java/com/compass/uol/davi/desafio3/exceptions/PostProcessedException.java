package com.compass.uol.davi.desafio3.exceptions;


@SuppressWarnings("serial")
public class PostProcessedException extends Exception{
	
	@Override
	public String getMessage() {
		return "Post processed";
	}
}
