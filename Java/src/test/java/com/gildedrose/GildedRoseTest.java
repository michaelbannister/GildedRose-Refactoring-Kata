package com.gildedrose;

import static com.gildedrose.Catalogue.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void agedBrieShouldIncreaseInQualityBeforeSellByDate() {
        Item brie = new Item(AGED_BRIE, 5, 10);
        Item agedBrie = age(brie);
        assertThat(agedBrie.quality).isEqualTo(11);
    }

    @Test
    public void agedBrieShouldApproachItsSellByDate() {
        Item brie = new Item(AGED_BRIE, 5, 10);
        Item agedBrie = age(brie);
        assertThat(agedBrie.sellIn).isEqualTo(4);
    }

    @Test
    public void agedBrieShouldIncreaseInQualityByTwoEachDayAfterSellByDate() {
        Item brie = new Item(AGED_BRIE, 0, 10);
        Item agedBrie = age(brie);
        assertThat(agedBrie.quality).isEqualTo(12);
    }

    @Test
    public void agedBrieShouldNotIncreaseInQualityAbove50() {
        Item brie = new Item(AGED_BRIE, 5, 50);
        Item agedBrie = age(brie);
        assertThat(agedBrie.quality).isEqualTo(50);
    }
    
    private Item age(Item item) {
        GildedRose app = new GildedRose(item);
        app.ageItems();
        return app.items[0];
    }

}
