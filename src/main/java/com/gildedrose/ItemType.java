package com.gildedrose;

import java.util.Arrays;

public enum ItemType {

    PLUS_5_DEXTERITY_VEST("+5 Dexterity Vest"),
    AGED_BRIE("Aged Brie"),
    ELIXIR_OF_MONGOOSE("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_MANA_CAKE("Conjured Mana Cake");

    private final String text;

    ItemType(String value) {
        this.text = value;
    }

    public static ItemType fromString(String text) {

        return Arrays.stream(values())
            .filter(it -> it.text.equalsIgnoreCase(text))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("unknown value: " + text));
    }
}
