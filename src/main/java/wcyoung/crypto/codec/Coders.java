package wcyoung.crypto.codec;

public class Coders {

    private static Base64 base64 = new Base64();
    private static Base64Url base64Url = new Base64Url();
    private static Hex hex = new Hex();

    private Coders() {}

    public static Base64 base64() {
        return base64;
    }

    public static Base64Url base64Url() {
        return base64Url;
    }

    public static Hex hex() {
        return hex;
    }

}
