package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void normalItemsShouldDecreaseInQuality() {
        Item apple = new Item("Apple", 1, 20);
        
        age(apple);
        assertThat(apple.quality).isEqualTo(19);
        
        age(apple);
        assertThat(apple.quality).isEqualTo(17);
    }

    @Test
    public void conjuredItemsShouldDecreaseInQualityTwiceAsFast() {
        Item conjuredCake = new Item("Conjured Cake", 1, 20);
        
        age(conjuredCake);
        assertThat(conjuredCake.quality).isEqualTo(18);
        
        age(conjuredCake);
        assertThat(conjuredCake.quality).isEqualTo(14);
    }
    
    @Test
    public void agedBrieShouldIncreaseInQuality() {
        Item brie = new Item(Catalogue.AGED_BRIE, 5, 10);
        age(brie);
        assertThat(brie.quality).isEqualTo(11);
    }
    
    @Test
    public void sulfurasShouldBeTreatedAsALegendaryItem() {
        Item sulfuras = new Item(Catalogue.SULFURAS, -1, 80);
        age(sulfuras);
        assertThat(sulfuras.quality).isEqualTo(80);
    }

    @Test
    public void backstagePassesShouldLoseValueAfterConcert() {
        Item backstagePass = new Item(Catalogue.BACKSTAGE_PASSES, 1, 20);
        
        age(backstagePass);
        assertThat(backstagePass.quality).isEqualTo(23);
        
        age(backstagePass);
        assertThat(backstagePass.quality).isEqualTo(0);
    }

    private void age(Item item) {
        GildedRose app = new GildedRose(item);
        app.ageItems();
    }

}
