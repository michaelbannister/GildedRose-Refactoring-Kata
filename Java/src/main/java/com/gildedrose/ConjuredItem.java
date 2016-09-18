package com.gildedrose;

public class ConjuredItem extends GildedItem {
    ConjuredItem(Item item) {
        super(item);
    }

    void age() {
        decreaseQuality(2);

        item.sellIn -= 1;

        if (hasPassedSellByDate()) {
            decreaseQuality(2);
        }
    }
}
