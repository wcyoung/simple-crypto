package wcyoung.crypto.core;

import wcyoung.crypto.codec.Coder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AesEncryptor {

    private final String ALGORITHM = "AES/CBC/PKCS5Padding";

    private final SecretKey secretKey;
    private final IvParameterSpec parameterSpec;
    private final Coder coder;

    public AesEncryptor(String key) {
        this(key, DefaultCryptoConstants.CODER);
    }

    public AesEncryptor(String key, Coder coder) {
        this.secretKey = generateKey(key);
        this.parameterSpec = defineSpec(key);
        this.coder = coder;
    }

    public String encrypt(String plainText) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
            return coder.encode(cipher.doFinal(plainText.getBytes()));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    public String decrypt(String cipherText) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
            return new String(cipher.doFinal(coder.decode(cipherText)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    private SecretKey generateKey(String key) {
        return new SecretKeySpec(hash(key, "SHA-256"), "AES");
    }

    private IvParameterSpec defineSpec(String key) {
        return new IvParameterSpec(hash(key, "MD5"));
    }

    private byte[] hash(String key, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(key.getBytes());
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoRuntimeException(e);
        }
    }

}
