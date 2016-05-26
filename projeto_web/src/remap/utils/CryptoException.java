package remap.utils;

public class CryptoException extends Exception {
	private static final long serialVersionUID = 6085087328451010811L;

	public CryptoException() {
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}