package com.gildedrose;

import java.util.List;

class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        ItemType type = ItemType.fromString(item.name);

        updateQuality(item, type);

        updateExpiration(item, type);

        if (isExpired(item)) {

            handleExpired(item, type);
        }
    }

    private void updateQuality(Item item, ItemType type) {
        if (type.equals(ItemType.AGED_BRIE)) {
            increaseQuality(item);
        }
        else if (type.equals(ItemType.BACKSTAGE_PASS)) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
        else if (type.equals(ItemType.SULFURAS)) {
        }
        else {
            decreaseQuality(item);
        }
    }

    private void updateExpiration(Item item, ItemType type) {
        if (type.equals(ItemType.SULFURAS)) {
            return;
        }
        decreaseExpiry(item);
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void handleExpired(Item item, ItemType type) {
        if (type.equals(ItemType.AGED_BRIE)) {
            increaseQuality(item);
        }
        else if (type.equals(ItemType.BACKSTAGE_PASS)) {
            item.quality = 0;
        }
        else if (!type.equals(ItemType.SULFURAS)) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
