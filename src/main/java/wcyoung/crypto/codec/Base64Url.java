package wcyoung.crypto.codec;

public class Base64Url implements Coder {

    @Override
    public String encode(byte[] bytes) {
        return java.util.Base64.getUrlEncoder().encodeToString(bytes);
    }

    @Override
    public byte[] decode(String text) {
        return java.util.Base64.getUrlDecoder().decode(text);
    }

}
