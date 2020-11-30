package wcyoung.crypto.core;

public class CryptoRuntimeException extends RuntimeException {

    public CryptoRuntimeException() {
        super();
    }

    public CryptoRuntimeException(String message) {
        super(message);
    }

    public CryptoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoRuntimeException(Throwable cause) {
        super(cause);
    }

}
