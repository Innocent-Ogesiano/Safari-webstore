package com.example.safariwebstore008.enums;

public enum ShoeSize {
    S1("35.5/5"), S2("36.5/5.5"),S3("37.5/6.5"), S4("38/7"),
    S5("39/7.5"), S6("39.5/8"),S7("40/9"), S8("41/9.5"),
    S9("41/10"), S10("41.5/10"),S11("42/11"), S12("43/12"),
    ;
    private  final String size;

    ShoeSize(String size) {
        this.size=size;
    }
}
