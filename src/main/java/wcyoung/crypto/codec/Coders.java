package wcyoung.crypto.codec;

public class Coders {

    private static final Base64 BASE64 = new Base64();
    private static final Base64Url BASE64_URL = new Base64Url();
    private static final Hex HEX = new Hex();

    private Coders() {}

    public static Base64 base64() {
        return BASE64;
    }

    public static Base64Url base64Url() {
        return BASE64_URL;
    }

    public static Hex hex() {
        return HEX;
    }

}
