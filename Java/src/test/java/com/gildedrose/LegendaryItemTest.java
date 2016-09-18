package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LegendaryItemTest {

    @Test
    public void legendaryItemShouldNotChangeInQuality() {
        LegendaryItem item = new LegendaryItem(new Item("legendary", 0, 80));
        
        item.age();
        
        assertThat(item.getQuality()).isEqualTo(80);
    }
}
