package com.driver.main;

import com.domain.model.Basket;

import java.io.IOException;
import java.util.Optional;

import static com.util.bootstrap.BootStrapFromCsv.*;

public class MainApp {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/resources/Basket.txt";
        if (args.length == 1){
            inputFilePath = args[0];
        }

        final Optional<Basket> basket1 = populateBasket(inputFilePath);
        basket1.ifPresent(Basket::printBasket);
        basket1.ifPresent(Basket::printTotalPrice);
/*

        Sample OutPut:

 This basket contain 4
=======
  FruitItem{Fruit=APPLE, Price=Rs 60.0, quantity=1 KILOGRAM}
  FruitItem{Fruit=BANANA, Price=Rs 16, quantity=10 DOZEN}
  FruitItem{Fruit=BANANA, Price=Rs 100, quantity=10 KILOGRAM}
  FruitItem{Fruit=PEACH, Price=Rs 100, quantity=20 PIECE}
=======

3220.0
*/

    }

    static void bootStrap(String path){

    }


}
