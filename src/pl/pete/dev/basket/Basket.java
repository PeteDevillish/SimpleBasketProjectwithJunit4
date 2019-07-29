package pl.pete.dev.basket;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Basket {
    private Map<Item, Integer> orderedItems;

    public Basket() {
        this.orderedItems = new HashMap<Item, Integer>();
    }

    public void addItem(Item item, int amount) {

        if (amount > 0) {
            if (orderedItems.containsKey(item)) {
                orderedItems.put(item, orderedItems.get(item) + amount);
            } else {
                orderedItems.put(item, amount);
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    public void removeItems(Item item, int amount) {
        if (amount > 0) {

            if (orderedItems.containsKey(item)) {
                if (orderedItems.get(item) > amount) {
                    orderedItems.put(item, orderedItems.get(item) - amount);
                } else if (orderedItems.get(item) == amount) {
                    orderedItems.remove(item);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException("amount have to be bigger than 0");
        }
    }

    //    Koszyk powinien także być w stanie policzyć sumaryczną wartość zamówienia oraz wyświetlić swoją zawartość.
//    Pamiętaj o poprawnym obsłużeniu sytuacji wyjątkowych np. usunięcie elementów z pustego koszyka czy dodaniu ujemnej liczby przedmiotów.
    public BigDecimal getSumaricPrice() {
        Iterator<Map.Entry<Item, Integer>> itr = orderedItems.entrySet().iterator();
        BigDecimal sumPrice = new BigDecimal(0);
        while (itr.hasNext()) {
            Map.Entry<Item, Integer> entry = itr.next();
            BigDecimal sumPriceOfProduct = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
            System.out.println(sumPriceOfProduct);
            sumPrice = sumPrice.add(sumPriceOfProduct);
        }
        return sumPrice;
    }

    public Map<Item, Integer> getOrderedItems() {
        return orderedItems;
    }

}
