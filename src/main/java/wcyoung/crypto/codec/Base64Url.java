package wcyoung.crypto.codec;

import java.util.Base64;

public class Base64Url implements Coder {

    private final boolean doPadding;

    public Base64Url() {
        this(true);
    }

    public Base64Url(boolean doPadding) {
        this.doPadding = doPadding;
    }

    @Override
    public String encode(byte[] bytes) {
        Base64.Encoder encoder = java.util.Base64.getUrlEncoder();
        if (!doPadding) {
            encoder = encoder.withoutPadding();
        }
        return encoder.encodeToString(bytes);
    }

    @Override
    public byte[] decode(String text) {
        return java.util.Base64.getUrlDecoder().decode(text);
    }

}
