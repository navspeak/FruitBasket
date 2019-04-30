package com.domain.enums;

import com.domain.model.ItemId;
import com.domain.valueTypes.Price;

import java.math.BigDecimal;

public enum Fruit /*implements ItemId */{
    BANANA (Price.of(BigDecimal.valueOf(10.0), Currency.RUPEES, ItemUnit.DOZEN)),
    ORANGE (Price.of(BigDecimal.valueOf(30.0), Currency.RUPEES, ItemUnit.KILOGRAM)),
    APPLE (Price.of(BigDecimal.valueOf(60.0), Currency.RUPEES, ItemUnit.KILOGRAM)),
    LEMON (Price.of(BigDecimal.valueOf(2.5), Currency.RUPEES, ItemUnit.PIECE)),
    PEACH(Price.of(BigDecimal.valueOf(100.0), Currency.RUPEES, ItemUnit.KILOGRAM)),;

    private Price defaultPrice;
    Fruit(Price price) {
        this.defaultPrice = price;
    }

    public Price getDefaultPrice() {
        return defaultPrice;
    }

//    public Integer getItemId(){
//        return ordinal() + 1;
//    }


}
