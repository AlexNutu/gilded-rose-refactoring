package com.gildedrose.type;

import com.gildedrose.Item;

public class AgedBrie extends GildedItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void handleExpired() {
        increaseQuality();
    }
}
