package com.mycompany.collectorvault.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
	
	public static void main(String[] args) {
		
		PasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
		
		System.out.println(passwordEnconder.encode("password"));
	}
	
}
