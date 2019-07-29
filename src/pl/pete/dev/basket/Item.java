package pl.pete.dev.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Item {
    private BigDecimal price;
    private String name;

    public Item(BigDecimal price, String name) {
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


}
