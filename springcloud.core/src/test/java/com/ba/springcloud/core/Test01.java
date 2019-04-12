package com.ba.springcloud.core;

import java.io.IOException;
import java.util.Base64;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2019年4月12日
 * @version 1.0
 */
public class Test01 {
	
	Base64.Encoder encoder = Base64.getEncoder();
	Base64.Decoder decoder = Base64.getDecoder();
	
	@Test
	public void testBase64() throws IOException {

		// BASE64编码
		String src = "client01:123456";
		
		src = encoder.encodeToString(src.getBytes("UTF-8"));
		System.out.println(src);

		// BASE64解码
		
		byte[] bytes = decoder.decode(src);
		System.out.println(new String(bytes, "UTF-8"));
	}
}
