package com.gildedrose;

/**
 * Template class
 */
public class GildedItem {

    private final Item item;

    public GildedItem(Item item) {
        this.item = item;
    }

    public void updateItem(Item item) {
        ItemType type = ItemType.fromString(item.name);

        updateQuality(item, type);

        updateExpiration(item, type);

        if (isExpired(item)) {
            handleExpired(item, type);
        }
    }

    protected void updateQuality(Item item, ItemType type) {
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

    protected void updateExpiration(Item item, ItemType type) {
        if (type.equals(ItemType.SULFURAS)) {
            return;
        }
        decreaseExpiry(item);
    }

    protected void handleExpired(Item item, ItemType type) {
        if (type.equals(ItemType.AGED_BRIE)) {
            increaseQuality(item);
        }
        else if (type.equals(ItemType.BACKSTAGE_PASS)) {
            item.quality = 0;
        }
        else if (type.equals(ItemType.SULFURAS)) {
        }
        else {
            decreaseQuality(item);
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void decreaseExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
