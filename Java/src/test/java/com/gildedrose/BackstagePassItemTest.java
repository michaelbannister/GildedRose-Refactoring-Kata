package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassItemTest {

    @Test
    public void backstagePassLosesAllQualityAfterSellByDate() {
        BackstagePassItem item = new BackstagePassItem(new Item("backstage", 0, 30));

        item.age();
        
        assertThat(item.getQuality()).isEqualTo(0);
    }

    @Test
    public void backstagePassIncreasesBy1WhenMoreThan10DaysBeforeConcert() {
        BackstagePassItem item = new BackstagePassItem(new Item("backstage", 15, 30));

        item.age(5);

        assertThat(item.getQuality()).isEqualTo(35);
    }
    
    @Test
    public void backstagePassIncreasesBy2Between10And6DaysBeforeConcert() {
        BackstagePassItem item = new BackstagePassItem(new Item("backstage", 10, 30));

        item.age(5);

        assertThat(item.getQuality()).isEqualTo(40);
    }
    
    @Test
    public void backstagePassIncreasesBy3ForThe5DaysBeforeConcert() {
        BackstagePassItem item = new BackstagePassItem(new Item("backstage", 5, 30));

        item.age(5);
        
        assertThat(item.getQuality()).isEqualTo(45);
    }

    @Test
    public void sellInPropertyContinuesToDecreaseBelowZero() {
        BackstagePassItem item = new BackstagePassItem(new Item("backstage", 0, 30));

        item.age();
        item.age();

        assertThat(item.getQuality()).isEqualTo(-2);
    }

}