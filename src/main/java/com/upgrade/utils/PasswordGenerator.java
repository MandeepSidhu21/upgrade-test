package com.upgrade.utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {
	
	private static final int passwordLength = 10;
	private static final Random random = new Random();
	
	public static String generatePassword() {
		String generatedString = RandomStringUtils.randomAlphanumeric(passwordLength);	
		Character.toUpperCase(generatedString.charAt(0));
		StringBuilder sb = new StringBuilder (String.valueOf (generatedString));
		sb.append(random.nextInt(90));
		return sb.toString();
	}

	

}
