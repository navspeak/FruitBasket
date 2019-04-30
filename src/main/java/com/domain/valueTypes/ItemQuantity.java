package com.domain.valueTypes;

import com.domain.enums.ItemUnit;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public class ItemQuantity implements Serializable {

    private Integer quantity;
    private final ItemUnit unit;

    private ItemQuantity(Integer value, ItemUnit unit) {
        this.quantity = value;
        this.unit = unit;
    }

    public ItemQuantity(ItemQuantity quantity) {
        this(quantity.quantity, quantity.unit);
    }

    public static ItemQuantity of(Integer qty, ItemUnit unit) {
        checkNotNull(qty);
        return new ItemQuantity(qty, unit);
    }

    public static ItemQuantity copyOf(ItemQuantity quantity) {
        checkNotNull(quantity);
        return new ItemQuantity(quantity);
    }

    public void increment() {
        quantity++;
    }

    public Integer intVal(){
       return quantity;
    }

    public ItemUnit getUnit(){
        return unit;
    }

    @Override
    public String toString() {
        return quantity + " " + unit;
    }
}
