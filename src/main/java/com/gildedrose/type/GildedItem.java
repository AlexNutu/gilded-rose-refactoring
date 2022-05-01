package com.gildedrose.type;

import com.gildedrose.Item;

/**
 * Template class for a standard item
 */
public class GildedItem {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    protected final Item item;

    public GildedItem(Item item) {
        this.item = item;
    }

    public void updateItem() {
        updateQuality();
        updateExpiration();

        if (isExpired()) {
            handleExpired();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateExpiration() {
        decreaseExpiry();
    }

    protected void handleExpired() {
        decreaseQuality();
    }

    protected void increaseQuality() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    protected void decreaseExpiry() {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }
}
