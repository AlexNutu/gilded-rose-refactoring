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
        if (!type.equals(ItemType.AGED_BRIE) && !type.equals(ItemType.BACKSTAGE_PASS)) {

            if (item.quality > 0) {
                if (!type.equals(ItemType.SULFURAS)) {
                    degradeQuality(item);
                }
            }
        }
        else {
            if (item.quality < 50) {
                increaseQuality(item);

                if (type.equals(ItemType.BACKSTAGE_PASS)) {
                    if (item.sellIn < 11 && item.quality < 50) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private void updateExpiration(Item item, ItemType type) {
        if (!type.equals(ItemType.SULFURAS)) {
            decreaseExpiry(item);
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void handleExpired(Item item, ItemType type) {
        if (!type.equals(ItemType.AGED_BRIE)) {
            if (!type.equals(ItemType.BACKSTAGE_PASS)) {
                if (item.quality > 0) {
                    if (!type.equals(ItemType.SULFURAS)) {
                       degradeQuality(item);
                    }
                }
            }
            else {
                item.quality = 0;
            }
        }
        else {
            if (item.quality < 50) {
                increaseQuality(item);
            }
        }
    }

    private void decreaseExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void degradeQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
