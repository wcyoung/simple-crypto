package wcyoung.crypto.core;

import org.junit.jupiter.api.Test;
import wcyoung.crypto.codec.Coder;
import wcyoung.crypto.codec.Coders;

import static org.junit.jupiter.api.Assertions.*;

class BlowfishEncryptorTest {

    private final Coder CODER = Coders.hex();
    private final String SECRET_KEY = "blowfish secret key";
    private final String PLAIN_TEXT = "blowfish encrypt test text!!";
    private final String CIPHER_TEXT = "25258c155922a3dc3bf5bf967e7566cb946f8731bc5f8ea89104b2aa9e1cdf1a";

    @Test
    void encrypt() throws CryptoException {
        BlowfishEncryptor encryptor = new BlowfishEncryptor(SECRET_KEY, CODER);
        String cipherText = encryptor.encrypt(PLAIN_TEXT);
        assertEquals(cipherText, CIPHER_TEXT);
    }

    @Test
    void decrypt() throws CryptoException {
        BlowfishEncryptor encryptor = new BlowfishEncryptor(SECRET_KEY, CODER);
        String plainText = encryptor.decrypt(CIPHER_TEXT);
        assertEquals(plainText, PLAIN_TEXT);
    }

}