package com.domain.model;

import com.domain.enums.Fruit;
import com.domain.enums.ItemType;
import com.domain.valueTypes.ItemQuantity;
import com.domain.valueTypes.Price;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class FruitItem implements Item {
    private final Fruit fruit;
    private final Price itemPrice;
    private ItemQuantity quantity;

    private FruitItem(Fruit fruit, Price price, ItemQuantity qty) {
        checkNotNull(fruit, "Fruit can't be null while constructing Fruit Item");
        this.fruit = fruit;
        if (price == null)
            this.itemPrice = fruit.getDefaultPrice();
        else
            this.itemPrice = price;
        if (qty == null)
            this.quantity = ItemQuantity.of(1, itemPrice.getUnit());
        else
            this.quantity = qty;
    }

    private FruitItem(Fruit fruit) {
        this(fruit, null, null);
    }

    // Static Factory methods to construct Fruit Item in various ways
    public static FruitItem of(Fruit fruit, Price price) {
        return new FruitItem(fruit, price, null );
    }

    public static FruitItem of(Fruit fruit, Price price, ItemQuantity qty) {
        checkArgument(price.getUnit().equals(qty.getUnit()), "There is a unit mismatch");
        return new FruitItem(fruit, price, qty);
    }

    public static FruitItem of(Fruit fruit) {
        return new FruitItem(fruit);
    }


    @Override
    public Price getItemPrice() {
        return this.itemPrice;
    }

    @Override
    public BigDecimal getItemPriceInBigDecimal() {
        return this.itemPrice.getActualPrice()
                .multiply(BigDecimal.valueOf(quantity.intVal()));
    }

    @Override
    public ItemType getItemType() { return ItemType.FRUIT;}

    @Override
    public ItemQuantity getQuantity() {
        final ItemQuantity copyOfQuantity = ItemQuantity.copyOf(quantity);
        return copyOfQuantity;
    }

    @Override
    public void incrementQuantity() {
        quantity.increment();
    }

    // Two fruits are equal they are the same fruit and have same price
    // Banana with price Rs. 10 and Banana with Price 20 are not considered equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitItem fruitItem = (FruitItem) o;
        return this.fruit == fruitItem.fruit &&
                Objects.equal(this.itemPrice, fruitItem.itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fruit, itemPrice);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Fruit", fruit)
                .add("Price", itemPrice)
                .add("quantity", quantity)
                .toString();
    }


}
