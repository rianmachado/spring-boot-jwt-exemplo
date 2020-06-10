package br.com.pitang.desafio.entities.utilits;

import org.springframework.util.DigestUtils;

public final class UtilEncryption {
	
	private UtilEncryption() {
		
	}

	public static String encryptToMD5(final String value) {
		return DigestUtils.md5DigestAsHex(value.getBytes());
	}

}
