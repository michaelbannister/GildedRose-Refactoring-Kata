package com.gildedrose;

abstract class GildedItem {

    protected final Item item;

    protected GildedItem(Item item) {
        this.item = item;
    }

    static GildedItem from(Item item) {
        if (item.name.equals(Catalogue.SULFURAS)) {
            return new LegendaryItem(item);
        }
        if (item.name.equals(Catalogue.BACKSTAGE_PASSES)) {
            return new BackstagePassItem(item);
        }
        if (item.name.equals(Catalogue.AGED_BRIE)) {
            return new AgedBrieItem(item);
        }
        if (item.name.startsWith("Conjured ")) {
            return new ConjuredItem(item);
        }
        return new StandardItem(item);
    }

    abstract void age();

    void age(int days) {
        for (int i = 0; i < days; i++) {
            age();
        }
    }

    public int getQuality() {
        return item.quality;
    }

    protected final void decreaseQuality(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("amount must be positive");
        }
        for (int i = 0; i < amount; i++) {
            decreaseQuality();
        }
    }
    
    protected final void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    protected final void increaseQuality() {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    protected final boolean hasPassedSellByDate() {
        return item.sellIn < 0;
    }

}
