package by.buyash.constant;

public enum Constant {

    MATRIX_SIZE(5),
    Y_CONSTANT(2);

    private int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
