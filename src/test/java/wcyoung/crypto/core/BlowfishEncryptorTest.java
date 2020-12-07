package wcyoung.crypto.core;

import org.junit.jupiter.api.Test;
import wcyoung.crypto.codec.Coder;
import wcyoung.crypto.codec.Coders;

import static org.junit.jupiter.api.Assertions.*;

class BlowfishEncryptorTest {

    private final Coder CODER = Coders.hex();
    private final String SECRET_KEY = "blowfish secret key";
    private final String PLAIN_TEXT = "blowfish encrypt test text!!";
    private final String CIPHER_TEXT = "b45b5988f3decb40a86155144e037bbf4b19ea3790d2a78dc05874d5a68e723e";

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