package wcyoung.crypto.core;

import org.junit.jupiter.api.Test;
import wcyoung.crypto.codec.Coder;
import wcyoung.crypto.codec.Coders;

import static org.junit.jupiter.api.Assertions.*;

class BlowfishEncryptorTest {

    private final Coder CODER = Coders.hex();
    private final String SECRET_KEY = "blowfish secret key";
    private final String PLAIN_TEXT = "blowfish encrypt test text!!";
    private final String CIPHER_TEXT = "2eb59860f7881f10a90ba57d2cee112de3bea7685f51e76ff4fc8677876693ba";

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