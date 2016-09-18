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
        return new StandardItem(item);
    }

    abstract void age();
    
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
