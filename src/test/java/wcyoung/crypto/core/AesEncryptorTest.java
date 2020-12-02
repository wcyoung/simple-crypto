package wcyoung.crypto.core;

import org.junit.jupiter.api.Test;
import wcyoung.crypto.codec.Coder;
import wcyoung.crypto.codec.Coders;

import static org.junit.jupiter.api.Assertions.*;

class AesEncryptorTest {

    private final Coder CODER = Coders.hex();
    private final String SECRET_KEY = "aes secret key";
    private final String PLAIN_TEXT = "aes encrypt test text!!";
    private final String CIPHER_TEXT = "131867f6d20e02898a75c3a8661cb6cc0b8745fac627d7df3de19378001995fb";

    @Test
    void encrypt() throws CryptoException {
        AesEncryptor encryptor = new AesEncryptor(SECRET_KEY, CODER);
        String cipherText = encryptor.encrypt(PLAIN_TEXT);
        assertEquals(cipherText, CIPHER_TEXT);
    }

    @Test
    void decrypt() throws CryptoException {
        AesEncryptor encryptor = new AesEncryptor(SECRET_KEY, CODER);
        String plainText = encryptor.decrypt(CIPHER_TEXT);
        assertEquals(plainText, PLAIN_TEXT);
    }

}