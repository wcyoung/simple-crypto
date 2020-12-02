package wcyoung.crypto.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HexTest {

    private final String PLAIN_TEXT = "hex encode/decode test text!!";
    private final String ENCODED_STRING = "68657820656e636f64652f6465636f6465207465737420746578742121";

    @Test
    void encode() {
        Hex hex = new Hex();
        String encodedString = hex.encode(PLAIN_TEXT.getBytes());
        assertEquals(encodedString, ENCODED_STRING);
    }

    @Test
    void decode() {
        Hex hex = new Hex();
        String string = new String(hex.decode(ENCODED_STRING));
        assertEquals(string, PLAIN_TEXT);
    }

}
