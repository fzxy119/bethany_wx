package com.bethany.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

/**
 * 密码处理方法.
 * 
 * @author a
 *
 */
public class LocalDesCoderUtils {
	private static final Logger logger = LoggerFactory
			.getLogger(LocalDesCoderUtils.class);
	private static final String PASSWORD_CRYPT_KEY = "_DleNetLoanYincAn__";
	public  static final String URL_CRYPT_KEY = "_DleNetLoanYincAnUrl__";
	private static final String DES = "DES";

	public static void main(String[] args) {

		String srcUrl = "http://127.0.0.1:8080/liji-app/view/user/ivlist";
		try {
			String msg = "signType=0&source=1&version=1.0&token=6DFC7D0C7B851E978C5DB3EC6936115A";
			if(srcUrl.contains("?")){
                srcUrl = srcUrl + "&encrypt_return_msg=" + LocalDesCoderUtils.encrypt(msg, LocalDesCoderUtils.URL_CRYPT_KEY) ;

            }else{
                srcUrl = srcUrl + "?encrypt_return_msg=" + LocalDesCoderUtils.encrypt(msg, LocalDesCoderUtils.URL_CRYPT_KEY);

            }
			System.out.println(srcUrl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	public static byte[] encrypt(byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) throws Exception {
		SecureRandom localSecureRandom = new SecureRandom();
		DESKeySpec localDESKeySpec = new DESKeySpec(paramArrayOfByte2);
		SecretKeyFactory localSecretKeyFactory = SecretKeyFactory
				.getInstance(DES);
		SecretKey localSecretKey = localSecretKeyFactory
				.generateSecret(localDESKeySpec);
		Cipher localCipher = Cipher.getInstance(DES);
		localCipher.init(1, localSecretKey, localSecureRandom);
		return localCipher.doFinal(paramArrayOfByte1);
	}

	public static byte[] decrypt(byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) throws Exception {
		SecureRandom localSecureRandom = new SecureRandom();
		DESKeySpec localDESKeySpec = new DESKeySpec(paramArrayOfByte2);
		SecretKeyFactory localSecretKeyFactory = SecretKeyFactory
				.getInstance(DES);
		SecretKey localSecretKey = localSecretKeyFactory
				.generateSecret(localDESKeySpec);
		Cipher localCipher = Cipher.getInstance(DES);
		localCipher.init(2, localSecretKey, localSecureRandom);
		return localCipher.doFinal(paramArrayOfByte1);
	}

	public static final String decrypt(String paramString) {
		try {
			return urlDecode(new String(decrypt(
					hex2byte(paramString.getBytes()),
					PASSWORD_CRYPT_KEY.getBytes())));
		} catch (Exception localException) {
		}
		return null;
	}

	public static final String decrypt(String paramString,String key) {
		try {
			return urlDecode(new String(decrypt(
					hex2byte(paramString.getBytes()),
					key.getBytes())));
		} catch (Exception localException) {
		}
		return null;
	}

	public static final String encrypt(String paramString) {
		try {
			return byte2hex(encrypt(urlEncode(paramString).getBytes(),
					PASSWORD_CRYPT_KEY.getBytes()));
		} catch (Exception localException) {
			logger.error("encrypt password error!", localException);
		}
		return null;
	}

	public static final String encrypt(String paramString,String key) {
		try {
			return byte2hex(encrypt(urlEncode(paramString).getBytes(),
					key.getBytes()));
		} catch (Exception localException) {
			logger.error("encrypt password error!", localException);
		}
		return null;
	}

	public static String byte2hex(byte[] paramArrayOfByte) {
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
			if (str2.length() == 1) {
				str1 = str1 + "0" + str2;
			} else {
				str1 = str1 + str2;
			}
		}
		return str1.toUpperCase();
	}

	public static byte[] hex2byte(byte[] paramArrayOfByte) {
		if (paramArrayOfByte.length % 2 != 0) {
			throw new IllegalArgumentException("长度不是偶数");
		}
		byte[] arrayOfByte = new byte[paramArrayOfByte.length / 2];
		for (int i = 0; i < paramArrayOfByte.length; i += 2) {
			String str = new String(paramArrayOfByte, i, 2);
			arrayOfByte[(i / 2)] = ((byte) Integer.parseInt(str, 16));
		}
		return arrayOfByte;
	}

	public static String urlEncode(String paramString) {
		if (StringUtils.isEmpty(paramString)) {
			return "";
		}
		String str;
		try {
			str = URLEncoder.encode(paramString, "UTF-8");
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			return "";
		}
		return str;
	}

	public static String urlDecode(String paramString) {
		if (StringUtils.isEmpty(paramString)) {
			return "";
		}
		String str = "";
		try {
			str = URLDecoder.decode(paramString, "UTF-8");
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			return "";
		}
		return str;
	}

}
