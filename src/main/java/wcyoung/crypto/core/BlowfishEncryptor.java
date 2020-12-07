package wcyoung.crypto.core;

import wcyoung.crypto.codec.Coder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BlowfishEncryptor {

    private final String ALGORITHM = "Blowfish";

    private final SecretKey secretKey;
    private final Coder coder;

    public BlowfishEncryptor(String key) {
        this(key, DefaultCryptoConstants.CODER);
    }

    public BlowfishEncryptor(String key, Coder coder) {
        this.secretKey = generateKey(key);
        this.coder = coder;
    }

    public String encrypt(String plainText) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return coder.encode(cipher.doFinal(plainText.getBytes()));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    public String decrypt(String cipherText) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(coder.decode(cipherText)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptoException(e);
        }
    }

    private SecretKey generateKey(String key) {
        return new SecretKeySpec(key.getBytes(), ALGORITHM);
    }

}
