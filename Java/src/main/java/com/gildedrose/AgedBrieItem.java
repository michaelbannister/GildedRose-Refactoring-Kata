package com.gildedrose;

public class AgedBrieItem extends GildedItem {
    
    protected AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    void age() {
        increaseQuality();
        
        item.sellIn -= 1;
        
        if (hasPassedSellByDate()) {
            increaseQuality();
        }
    }
}
