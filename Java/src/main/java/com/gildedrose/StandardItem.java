package com.gildedrose;

public class StandardItem extends GildedItem {
    StandardItem(Item item) {
        super(item);
    }

    void age() {
        if (decreasesInQualityOverTime(item)) {
            decreaseQuality(item);
        } else if (increasesInQualityOverTime(item)) {
            increaseQuality(item);
        }

        item.sellIn -= 1;

        if (isPastSellByDate(item)) {
            if (increasesInQualityOverTime(item)) {
                increaseQuality(item);
            } else if (decreasesInQualityOverTime(item)) {
                decreaseQuality(item);
            }
        }
    }

    private boolean isPastSellByDate(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private boolean decreasesInQualityOverTime(Item item) {
        return !increasesInQualityOverTime(item);
    }

    private boolean increasesInQualityOverTime(Item item) {
        return item.name.equals(Catalogue.AGED_BRIE) || item.name.equals(Catalogue.BACKSTAGE_PASSES);
    }
}