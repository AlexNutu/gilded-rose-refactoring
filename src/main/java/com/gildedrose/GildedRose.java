package com.gildedrose;

import java.util.List;

import com.gildedrose.type.GildedItem;

class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void dailyUpdate() {
        for (final Item item : items) {
            GildedItem gildedItem = GuildedItemFactory.create(item);
            gildedItem.updateItem();
        }
    }
}
