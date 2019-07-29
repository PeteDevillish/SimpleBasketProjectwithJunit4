package pl.pete.dev.basket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BasketTest {

    Basket testee;
    @Before
    public void setUp() throws Exception {
        testee = new Basket();
        Item carrot = new Item(new BigDecimal(18.2), "Carrot");
        testee.addItem(carrot, 11);
    }

    @Test
    public void addItem() {
        testee.addItem(new Item(new BigDecimal(12), "Banana"), 12);
        assertEquals(testee.getOrderedItems().size(), 2);
    }
    @Test
    public void addItem2() {
        Item banana = new Item(new BigDecimal(12), "Banana");
        testee.addItem(banana, 12);
        assertTrue(testee.getOrderedItems().get(banana).equals(12));
    }



    @Test
    public void removeItems() {
        Item banana = new Item(new BigDecimal(12), "Banana");
        testee.addItem(banana, 12);
        testee.removeItems(banana, 5);
        assertTrue(testee.getOrderedItems().get(banana) == 7);
    }

    @Test
    public void getSumaricPrice() {
        assertEquals(testee.getSumaricPrice(), new BigDecimal(11 * 18.2).setScale(2, RoundingMode.HALF_EVEN));
    }

}