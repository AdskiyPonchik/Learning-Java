package stepik;
import java.lang.CharSequence;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private final byte[] data;
    private AsciiCharSequence(byte[] data){
        this.data = Arrays.copyOf(data, data.length);
    }
    @Override
    public int length() {
        return this.data.length;
    }
    @Override
    public char charAt(int i) {
        return (char)(this.data[i] & 0xFF);
    }
    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.data, start, end));
    }

    @Override
    public String toString(){
        return new String(this.data, StandardCharsets.US_ASCII);
    }
}
