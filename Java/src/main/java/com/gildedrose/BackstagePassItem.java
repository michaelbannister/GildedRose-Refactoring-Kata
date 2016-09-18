package com.gildedrose;

public class BackstagePassItem extends GildedItem {
    BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    void age() {
        item.sellIn -= 1;

        if (hasPassedSellByDate()) {
            item.quality = 0;
            return;
        }
        
        increaseQuality();
        if (item.sellIn < 10) {
            increaseQuality();
        }
        if (item.sellIn < 5) {
            increaseQuality();
        }
    }
    
    void age(int days) {
        for (int i = 0; i < days; i++) {
            age();
        }
    }
}
