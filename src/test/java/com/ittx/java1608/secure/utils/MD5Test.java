package com.ittx.java1608.secure.utils;

import org.junit.Test;

public class MD5Test {
	private String s = "abcd12";

	@Test
	public void testMd5crypt() {
		String ms = MD5.md5crypt(s);
		System.out.println(ms);
	}
	
	@Test
	public void testJDKBase64(){
		String encoderStr = java.util.Base64.getEncoder().encodeToString(s.getBytes());
		System.out.println("encode :"+encoderStr);
		
		String decodeStr = new String(java.util.Base64.getDecoder().decode(encoderStr));
		System.out.println("decodeStr :"+decodeStr);
	}
	
	@Test
	public void testCodecBase64(){
		String encoderStr = org.apache.commons.codec.binary.Base64.encodeBase64String(s.getBytes());
		System.out.println("encode :"+encoderStr);
		
		String decodeStr = new String(org.apache.commons.codec.binary.Base64.decodeBase64(encoderStr));
		System.out.println("decodeStr :"+decodeStr);
	}
}
