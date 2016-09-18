package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieItemTest {
    
    @Test
    public void agedBrieIncreasesInQualityEachDayBeforeSellByDate() {
        AgedBrieItem item = new AgedBrieItem(new Item("backstage", 5, 10));

        item.age(5);

        assertThat(item.getQuality()).isEqualTo(15);
    }
    
    @Test
    public void agedBrieIncreasesInQualityBy2EachDayAfterSellByDate() {
        AgedBrieItem item = new AgedBrieItem(new Item("backstage", 0, 10));

        item.age(5);

        assertThat(item.getQuality()).isEqualTo(20);
    }
}