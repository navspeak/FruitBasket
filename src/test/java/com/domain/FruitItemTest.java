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

public class FruitItemTest {

    @Test
    public void testItemCreation_DefaultParam(){
        Item item = FruitItem.of(Fruit.APPLE);
        System.out.println(item);
        assert item.toString().contentEquals(
                "FruitItem{Fruit=APPLE, Price=Rs 60.0, quantity=1 KILOGRAM}"
        );
    }

    @Test
    public void testItemCreation_UserProvidedPrice(){
        Item item1 = FruitItem.of(Fruit.APPLE,
                Price.of(BigDecimal.valueOf(100.0), Currency.RUPEES, ItemUnit.KILOGRAM));
        System.out.println(item1);
       assert item1.toString().contentEquals(
               "FruitItem{Fruit=APPLE, Price=Rs 100.0, quantity=1 KILOGRAM}"
       );
    }

    @Test
    public void testItemEquality(){

        Item item1 = FruitItem.of(Fruit.APPLE,
                Price.of(BigDecimal.valueOf(100.0), Currency.RUPEES, ItemUnit.KILOGRAM));
        Item item2 = FruitItem.of(Fruit.APPLE);
        assert  !item1.equals(item2);

        Item item3 = FruitItem.of(Fruit.BANANA,
                Price.of(BigDecimal.valueOf(10.0), Currency.RUPEES, ItemUnit.DOZEN));
        Item item4 = FruitItem.of(Fruit.APPLE);

        assert  item2.equals(item4);

        Item item5 = FruitItem.of(Fruit.BANANA,
                Price.of(BigDecimal.valueOf(3.0), Currency.RUPEES, ItemUnit.PIECE));
        assert !item3.equals(item5);

    }

}
