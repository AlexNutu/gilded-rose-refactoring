package com.gildedrose.type;

import com.gildedrose.Item;

public class Conjured extends GildedItem {
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }
}
