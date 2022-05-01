package com.gildedrose;

import static com.gildedrose.ItemType.AGED_BRIE;
import static com.gildedrose.ItemType.BACKSTAGE_PASS;
import static com.gildedrose.ItemType.SULFURAS;

import com.gildedrose.type.AgedBrie;
import com.gildedrose.type.BackstagePass;
import com.gildedrose.type.GildedItem;
import com.gildedrose.type.Sulfuras;

public class GuildedItemFactory {

    static GildedItem create(Item item) {
        ItemType type = ItemType.fromString(item.name);

        if (type.equals(SULFURAS)) {
            return new Sulfuras(item);
        }
        if (type.equals(AGED_BRIE)) {
            return new AgedBrie(item);
        }
        if (type.equals(BACKSTAGE_PASS)) {
            return new BackstagePass(item);
        }

        return new GildedItem(item);
    }
}
