package com.gildedrose;

public class StandardItem extends GildedItem {
    StandardItem(Item item) {
        super(item);
    }

    void age() {
        decreaseQuality();

        item.sellIn -= 1;

        if (hasPassedSellByDate()) {
            decreaseQuality();
        }
    }
}
