package wcyoung.crypto.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Base64UrlTest {

    private final String PLAIN_TEXT = "base64 url encode/decode test text!!";
    private final String ENCODED_STRING = "YmFzZTY0IHVybCBlbmNvZGUvZGVjb2RlIHRlc3QgdGV4dCEh";

    @Test
    void encode() {
        Base64 base64 = new Base64();
        String encodedString = base64.encode(PLAIN_TEXT.getBytes());
        assertEquals(encodedString, ENCODED_STRING);
    }

    @Test
    void decode() {
        Base64 base64 = new Base64();
        String string = new String(base64.decode(ENCODED_STRING));
        assertEquals(string, PLAIN_TEXT);
    }

}
