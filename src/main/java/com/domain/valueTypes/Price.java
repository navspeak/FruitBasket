package com.domain.valueTypes;

import com.domain.enums.Currency;
import com.domain.enums.ItemUnit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private final BigDecimal price;
    private final Currency currency;
    private final ItemUnit unit;

    private Price(BigDecimal price, Currency currency, ItemUnit unit) {
        this.price = price;
        this.currency = currency;
        this.unit = unit;
    }

    public static Price of(BigDecimal price, Currency currency, ItemUnit unit)
    {
        //TODO: In future support multiple currency
        // For now there's support for Indian Rupees only
        Preconditions.checkArgument(currency.equals(Currency.RUPEES),
                "Sorry, we don't support " + currency + "yet");
        return new Price(price, currency, unit);
    }

    public ItemUnit getUnit(){
        return this.unit;
    }

    public BigDecimal getActualPrice(){
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        //TODO: take currency into consideration when multi currency
        // support is added
        if (obj instanceof Price) {
            Price other = (Price) obj;
            return Objects.equals(this.price, other.price);
        }
        return false;
    }

    @Override
    public int hashCode() {
        //TODO: take currency into consideration when multi currency
        // support is added
        return Objects.hash(this.price);
    }

    @Override
    public String toString() {
        return  this.currency + " " + this.price;
    }
}
