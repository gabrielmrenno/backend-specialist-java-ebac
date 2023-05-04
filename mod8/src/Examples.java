public class Examples {
    // variable can be initialize
    private int code = 1;
    private long biggerCode;
    private float decimalValueWithDouble;
    private String text;
    private boolean status;

    public Examples(int value) {
        this.code = value;
    }

    public Examples() {

    }

    // need to "f" on the final of value
    private float decimalValue = 10.5f;
    private short shortValue;
    private byte byteValue;

    public String returnText() {
        return "text";
    }

    public int returnInt() {
        return 10;
    }
}
