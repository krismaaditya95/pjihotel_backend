package com.mini.project.hotel.config;

public interface PasswordEncoder {
	String encode(CharSequence rawPassword);
	
	boolean verify(CharSequence rawPassword, String encodedPassword);
}
