package com.ssm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtils {
	private static final Logger logger = LogManager.getLogger(TokenUtils.class.getName());

	public static String getToken(){
		return "this is my token";
	}

}
