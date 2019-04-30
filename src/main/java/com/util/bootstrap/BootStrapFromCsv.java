package com.util.bootstrap;

import com.domain.enums.Currency;
import com.domain.enums.Fruit;
import com.domain.enums.ItemUnit;
import com.domain.model.Basket;
import com.domain.model.FruitItem;
import com.domain.model.Item;
import com.domain.valueTypes.ItemQuantity;
import com.domain.valueTypes.Price;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class BootStrapFromCsv {

    /**
     * Checks if a string is valid file path
     * @param path
     * @return absolute file path if the input is valid
     *         else return null
     */
    public static Optional<String> getAbsolutePath(String path){
        if (path == null) return null;
        try {
            File file = new File(path);
            if (file.exists() == true) {
                return Optional.of(file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println(path + "doesn't exist. Moving on...");
            // return null
        }
        return null;
    }
    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Optional<Basket> populateBasket(String fileName) throws IOException {
        Optional<String> absolutePath = getAbsolutePath(fileName);
        if (!absolutePath.isPresent()) return Optional.empty();
        Path filePath = Paths.get(absolutePath.get());
        Basket basket = new Basket();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = "";

            while ((line = reader.readLine()) != null){

                String fruitName;
                Fruit fruit;
                BigDecimal price;
                Integer qty;
                String unitName;
                ItemUnit itemUnit;
                Item item = null;

                try {
                    if (line.startsWith("#"))
                        continue;
                    final String[] split = line.split(",");
                    if (split.length == 1) {
                        fruitName = split[0];
                        fruit = Fruit.valueOf(fruitName.toUpperCase());
                        item = FruitItem.of(fruit);
                    } else if (split.length == 4) {
                        fruitName = split[0];
                        fruit = Fruit.valueOf(fruitName.toUpperCase());
                        price = new BigDecimal(split[1]);
                        qty = Integer.valueOf(split[2]);
                        unitName = split[3];
                        itemUnit = ItemUnit.valueOf(unitName.toUpperCase());
                        item = FruitItem.of(fruit, Price.of(price, Currency.RUPEES, itemUnit),
                                ItemQuantity.of(qty, itemUnit));
                    } else {
                        System.out.println("Invalid line continuing to next...");
                    }
                    basket.addItem(item);
                } catch (IllegalArgumentException e){
                    System.out.println("Unsupported Type" + e.getMessage());
                    System.out.println("Invalid line continuing to next...");
                }
            }
        }
        return Optional.of(basket);
    }
}
