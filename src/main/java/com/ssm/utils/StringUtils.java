package com.ssm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	private static final Logger logger = LogManager.getLogger(StringUtils.class.getName());

	public static String toMD5(String str){
			if(str ==null )
				return null;
			try {
				// 生成一个MD5加密计算摘要
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
		        // 计算md5函数
		        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
				return new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				logger.error("MD5加密失败！" + e.getMessage());
			}
	        return null;
	}
}
