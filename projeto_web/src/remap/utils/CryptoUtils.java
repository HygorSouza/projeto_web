package remap.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES";
	public static final String chave = "1234567890123456";

	public static byte[] encrypt(String key, byte[] input)
			throws CryptoException {
		return doCrypto(Cipher.ENCRYPT_MODE, key, input);
	}

	public static byte[] decrypt(String key, byte[] input)
			throws CryptoException {
		return doCrypto(Cipher.DECRYPT_MODE, key, input);
	}


	private static byte[] doCrypto(int cipherMode, String key, byte[] input)
			throws CryptoException {
			try {
				Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				cipher.init(cipherMode, secretKey);

				return cipher.doFinal(input);
				
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException
					| IllegalBlockSizeException | BadPaddingException e) {
				throw new CryptoException("Erro ao encriptar/decriptar", e);
			}
	}
}
