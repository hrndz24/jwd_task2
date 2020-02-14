package by.buyanova.constant;

public enum StringConstant {

    OUTPUT_FILE_PATH("output.txt");

    private String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
