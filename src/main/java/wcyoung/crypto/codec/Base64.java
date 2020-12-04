package wcyoung.crypto.codec;

public class Base64 implements Coder {

    private final boolean doPadding;

    public Base64() {
        this(true);
    }

    public Base64(boolean doPadding) {
        this.doPadding = doPadding;
    }

    @Override
    public String encode(byte[] bytes) {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        if (!doPadding) {
            encoder = encoder.withoutPadding();
        }
        return encoder.encodeToString(bytes);
    }

    @Override
    public byte[] decode(String text) {
        return java.util.Base64.getDecoder().decode(text);
    }

}
