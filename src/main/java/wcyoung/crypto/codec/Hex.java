package wcyoung.crypto.codec;

public class Hex implements Coder {

    @Override
    public String encode(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length);
        for (byte aByte : bytes) {
            if ((aByte & 0xFF) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(aByte & 0xFF, 16));
        }
        return sb.toString();
    }

    @Override
    public byte[] decode(String text) {
        int length = text.length() >> 1;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int index = i << 1;
            String digit = text.substring(index, index + 2);
            bytes[i] = (byte) Integer.parseInt(digit, 16);
        }
        return bytes;
    }

}
