package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class GildedRose {
    Item[] items;
    private final List<GildedItem> gildedItems;

    public GildedRose(Item... items) {
        this.items = items;
        gildedItems = Stream.of(items).map(GildedItem::from).collect(toList());
    }

    public void ageItems() {
        gildedItems.forEach(GildedItem::age);
    }


}
