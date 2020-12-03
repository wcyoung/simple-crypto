package wcyoung.crypto.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Base64UrlTest {

    private final String PLAIN_TEXT = "base64 url encode/decode test text!!";
    private final String ENCODED_STRING = "YmFzZTY0IHVybCBlbmNvZGUvZGVjb2RlIHRlc3QgdGV4dCEh";

    @Test
    void encode() {
        Base64Url base64Url = new Base64Url();
        String encodedString = base64Url.encode(PLAIN_TEXT.getBytes());
        assertEquals(encodedString, ENCODED_STRING);
    }

    @Test
    void decode() {
        Base64Url base64Url = new Base64Url();
        String string = new String(base64Url.decode(ENCODED_STRING));
        assertEquals(string, PLAIN_TEXT);
    }

}
