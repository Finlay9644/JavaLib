package JLib.util;

public class StringBuilder implements CharSequence {

    private static final int DEFAULT_SIZE = 1 << 4;

    private int size, index;
    private char[] value;

    public StringBuilder() {
        size = DEFAULT_SIZE;
        index = 0;

        value = new char[size];
    }
    public StringBuilder(CharSequence content) {
        index = content.length();
        size = Integer.highestOneBit(index);

        value = new char[size];
        System.arraycopy(content.toString().toCharArray(), 0, value, 0, content.length());
    }

    private void checkSize() {
        if(index > size)
            size = size << 1;

        char[] newValue = new char[size];
        System.arraycopy(value, 0, newValue, 0, value.length);

        value = newValue;
    }
    private void checkSize(int size) {
        while(index + size > this.size)
            this.size = this.size << 1;

        char[] newValue = new char[size];
        System.arraycopy(value, 0, newValue, 0, value.length);

        value = newValue;
    }

    @Override
    public int length() {
        return index;
    }

    @Override
    public char charAt(int index) {
        return value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new String(value).subSequence(start, end);
    }
}