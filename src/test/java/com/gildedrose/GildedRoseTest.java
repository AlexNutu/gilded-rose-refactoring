package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private GildedRose app;

    @Test
    void testQualityDegradesTwiceAsFastWhenDateHasPassed() {
        int initialQuality = 7;
        int sellInNegative = -1;
        Item elixirOfTheMongoose = new Item("Elixir of the Mongoose", sellInNegative, initialQuality);

        List<Item> items = Collections.singletonList(elixirOfTheMongoose);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(initialQuality - 2, finalQuality);
    }

    @Test
    void testQualityIsNeverNegative() {
        int qualityZero = 0;
        Item elixirOfTheMongoose = new Item("Elixir of the Mongoose", 2, qualityZero);

        List<Item> items = Collections.singletonList(elixirOfTheMongoose);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(qualityZero, finalQuality);
    }

    @Test
    void testQualityIsNeverMoreThan50() {
        int qualityFifty = 50;
        Item agedBrie = new Item("Aged Brie", 2, qualityFifty);

        List<Item> items = Collections.singletonList(agedBrie);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(qualityFifty, finalQuality);
    }

    @Test
    void test_AgedBrie_QualityIncreasesOverTime() {
        int initialQuality = 20;
        Item agedBrie = new Item("Aged Brie", 2, initialQuality);

        List<Item> items = Collections.singletonList(agedBrie);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(initialQuality + 1, finalQuality);
    }

    @Test
    void test_Sulfuras_NeverHasToBeSoldOrDecreaseInQuality() {
        int initialQuality = 80;
        int initialSellIn = 2;
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);

        List<Item> items = Collections.singletonList(sulfuras);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        int finalSellIn = items.get(0).sellIn;
        assertEquals(initialQuality, finalQuality);
        assertEquals(initialSellIn, finalSellIn);
    }

    @Test
    void test_BackStagePass_QualityIncreaseBy2_When10Days() {
        int initialQuality = 20;
        int sellIn = 10;
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, initialQuality);

        List<Item> items = Collections.singletonList(backstagePass);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(initialQuality + 2, finalQuality);
    }

    @Test
    void test_BackStagePass_QualityIncreaseBy3_When5Days() {
        int initialQuality = 20;
        int sellIn = 5;
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, initialQuality);

        List<Item> items = Collections.singletonList(backstagePass);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(initialQuality + 3, finalQuality);
    }

    @Test
    void test_BackStagePass_QualityDropsTo0_When0Days() {
        int initialQuality = 20;
        int sellIn = 0;
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, initialQuality);

        List<Item> items = Collections.singletonList(backstagePass);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        assertEquals(0, finalQuality);
    }

    @Test
    void test_StandardItem_QualityAndSellInDecrease() {
        int initialQuality = 20;
        int initialSellIn = 2;
        Item dexterityVest = new Item("+5 Dexterity Vest", initialSellIn, initialQuality);

        List<Item> items = Collections.singletonList(dexterityVest);

        app = new GildedRose(items);
        app.dailyUpdate();

        int finalQuality = items.get(0).quality;
        int finalSellIn = items.get(0).sellIn;
        assertEquals(initialQuality - 1, finalQuality);
        assertEquals(initialSellIn - 1, finalSellIn);
    }

    @Test
    void test_ConjuredItem_QualityDecreasesTwiceAsFast() {
        // TODO:
    }
}
