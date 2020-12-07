package wcyoung.crypto.core;

import wcyoung.crypto.codec.Coder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlowfishEncryptor {

    private final String ALGORITHM = "Blowfish/CBC/PKCS5Padding";

    private final SecretKey secretKey;
    private final IvParameterSpec parameterSpec;
    private final Coder coder;

    public BlowfishEncryptor(String key) {
        this(key, DefaultCryptoConstants.CODER);
    }

    public BlowfishEncryptor(String key, Coder coder) {
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
        return new SecretKeySpec(key.getBytes(), "Blowfish");
    }

    private IvParameterSpec defineSpec(String key) {
        byte[] iv = new byte[8];
        System.arraycopy(hash(key), 0, iv, 0, iv.length);
        return new IvParameterSpec(iv);
    }

    private byte[] hash(String key) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(key.getBytes());
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoRuntimeException(e);
        }
    }

}
