package com.domain.model;

import com.domain.enums.ItemType;
import com.domain.valueTypes.ItemQuantity;
import com.domain.valueTypes.Price;

import java.math.BigDecimal;
import java.util.Optional;

public interface Item {
    // When an item is constructor, either a default price
    // or a custom price is set.
    Price getItemPrice();
    //Utility method to aid price calculation
    BigDecimal getItemPriceInBigDecimal();
    // Currently the only item type supported is "Fruit"
    // We might want to support other item types in future
    ItemType getItemType();
    ItemQuantity getQuantity();
    void incrementQuantity();
}
