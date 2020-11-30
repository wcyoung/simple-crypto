package wcyoung.crypto.codec;

public class Base64 implements Coder {

    @Override
    public String encode(byte[] bytes) {
        return java.util.Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public byte[] decode(String text) {
        return java.util.Base64.getDecoder().decode(text);
    }

}
