package by.buyanova.constant;

public enum IntegerConstant {

    MATRIX_SIZE(5),
    THREAD_GROUP_QUANTITY(2);

    private int value;

    IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
