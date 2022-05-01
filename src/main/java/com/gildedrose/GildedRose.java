package com.gildedrose;

import java.util.List;

class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void dailyUpdate() {
        for (final Item item : items) {
            GildedItem gildedItem = new GildedItem(item);
            gildedItem.updateItem(item);
        }
    }
}
