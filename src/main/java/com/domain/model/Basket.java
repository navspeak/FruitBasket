package com.domain.model;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Basket {

    private Set<Item> items;

    public Basket() {
        items = new HashSet<>();
    }

    public void addItem(Item item){
        Preconditions.checkNotNull(item, "Null item can't be added to a basket");
        // If an item is already there in the set, we just need to increment its quantity
        if (items.contains(item)){
            items.stream().filter(i -> i.equals(item))
                    .findFirst().ifPresent(i->i.incrementQuantity());
        } else
            items.add(item);

    }


    // utility to print the basket in a verbose way
    public void printBasket() {
        StringBuilder sb = new StringBuilder();
        sb.append("This basket contain "+items.size())
                .append("\n")
                .append("=======\n");

        for (Item item: items) {
            sb.append("  " + item.toString()).append("\n");
        }
        sb.append("=======\n");
        System.out.println(sb.toString());
    }

    public BigDecimal getTotalPrice(){
        return items.stream()
                .map(Item::getItemPriceInBigDecimal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Utility method. Useful in invoice priniting
    public void printTotalPrice(){
        System.out.println("Total Price => " + getTotalPrice());
    }

}