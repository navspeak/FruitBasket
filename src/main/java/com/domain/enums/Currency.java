package com.domain.enums;

public enum Currency {

    RUPEES("Rs");
    //TODO: support multiple currency
    // USD("$"),
    // GBP("#");

    private String symbol;
    Currency(String symbol) {this.symbol = symbol;};
    @Override
    public String toString() { return this.symbol;}

}
