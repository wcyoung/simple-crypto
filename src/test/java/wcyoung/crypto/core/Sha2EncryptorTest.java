package wcyoung.crypto.core;

import org.junit.jupiter.api.Test;
import wcyoung.crypto.codec.Coder;
import wcyoung.crypto.codec.Coders;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sha2EncryptorTest {

    private final Coder CODER = Coders.hex();
    private final String PLAIN_TEXT = "sha2 encrypt test text!!";
    private final String CIPHER_TEXT_256 = "85e5adf29aa42b5138238eebbbbdd2e6ffd1431590146be4d8dd81c3656634b2";
    private final String CIPHER_TEXT_512 = "6daf2dc3bb93a9462d79aac07565647556d100bc498247bc576e48cd65576a209b9c8f48785df513d423fcd7570de1c48d46942555c0bf02337c96ecb4a37a0b";

    @Test
    public void encrypt256() {
        Sha2Encryptor encryptor = new Sha2Encryptor(CODER);
        String cipherText = encryptor.encrypt256(PLAIN_TEXT);
        assertEquals(cipherText, CIPHER_TEXT_256);
    }

    @Test
    public void encrypt512() {
        Sha2Encryptor encryptor = new Sha2Encryptor(CODER);
        String cipherText = encryptor.encrypt512(PLAIN_TEXT);
        assertEquals(cipherText, CIPHER_TEXT_512);
    }

    @Test
    public void encrypt() {
        Sha2Encryptor encryptor = new Sha2Encryptor(CODER);
        String cipherText = encryptor.encrypt(PLAIN_TEXT, Sha2Encryptor.SHA_256);
        assertEquals(cipherText, CIPHER_TEXT_256);
    }

}
