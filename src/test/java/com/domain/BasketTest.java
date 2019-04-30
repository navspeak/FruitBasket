package com.domain;

import com.domain.enums.Currency;
import com.domain.enums.Fruit;
import com.domain.enums.ItemUnit;
import com.domain.model.Basket;
import com.domain.model.FruitItem;
import com.domain.model.Item;
import com.domain.valueTypes.Price;
import org.junit.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    public void testBasketPrice(){

        Item item1 = FruitItem.of(Fruit.APPLE,
                Price.of(BigDecimal.valueOf(100.0), Currency.RUPEES, ItemUnit.KILOGRAM));
        Item item2 = FruitItem.of(Fruit.APPLE);
        Item item3 = FruitItem.of(Fruit.BANANA,
                Price.of(BigDecimal.valueOf(10.40), Currency.RUPEES, ItemUnit.DOZEN));
        Item item4 = FruitItem.of(Fruit.APPLE);
        Item item5 = FruitItem.of(Fruit.BANANA,
                Price.of(BigDecimal.valueOf(3.50), Currency.RUPEES, ItemUnit.PIECE));
        Item item6 = FruitItem.of(Fruit.APPLE);

        Basket basket = new Basket();
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);
        basket.addItem(item6);

        basket.printBasket();
        final BigDecimal totalPrice = basket.getTotalPrice();
        System.out.println("Total Price: " + totalPrice);
        assert totalPrice.equals(BigDecimal.valueOf(293.90));


    }
}
