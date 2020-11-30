package wcyoung.crypto.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodersTest {

    @Test
    void base64() {
        assertEquals(Coders.base64().getClass(), Base64.class);
    }

    @Test
    void base64Url() {
        assertEquals(Coders.base64Url().getClass(), Base64Url.class);
    }

    @Test
    void hex() {
        assertEquals(Coders.hex().getClass(), Hex.class);
    }

}
