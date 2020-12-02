package wcyoung.crypto.core;

import wcyoung.crypto.codec.Coder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha2Encryptor {

    public static final String SHA_256 = "SHA-256";
    public static final String SHA_512 = "SHA-512";

    private final Coder coder;

    public Sha2Encryptor() {
        this(DefaultCryptoConstants.CODER);
    }

    public Sha2Encryptor(Coder coder) {
        this.coder = coder;
    }

    public String encrypt256(String plainText) {
        return encrypt(plainText, SHA_256);
    }

    public String encrypt512(String plainText) {
        return encrypt(plainText, SHA_512);
    }

    public String encrypt(String plainText, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(plainText.getBytes());
            return coder.encode(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoRuntimeException(e);
        }
    }

}
