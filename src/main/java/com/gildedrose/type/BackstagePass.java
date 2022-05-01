package com.gildedrose.type;

import com.gildedrose.Item;

public class BackstagePass extends GildedItem {

    private static final int FIRST_THRESHOLD = 10;
    private static final int SECOND_THRESHOLD = 5;

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn <= FIRST_THRESHOLD) {
            increaseQuality();
        }
        if (item.sellIn <= SECOND_THRESHOLD) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpired() {
        item.quality = 0;
    }
}
