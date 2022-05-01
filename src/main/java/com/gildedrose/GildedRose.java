package com.gildedrose;

import java.util.List;

class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            ItemType type = ItemType.fromString(item.name);

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

            if (!type.equals(ItemType.SULFURAS)) {
                decreaseExpiry(item);
            }

            if (item.sellIn < 0) {

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
