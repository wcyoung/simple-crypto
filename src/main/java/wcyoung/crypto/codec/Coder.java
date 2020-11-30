package wcyoung.crypto.codec;

public interface Coder {

    String encode(byte[] bytes);

    byte[] decode(String text);

}
