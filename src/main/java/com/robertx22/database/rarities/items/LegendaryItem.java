package com.robertx22.database.rarities.items;

import com.robertx22.database.MinMax;
import com.robertx22.database.rarities.ItemRarity;
import com.robertx22.database.rarities.base.BaseLegendary;

public class LegendaryItem extends BaseLegendary implements ItemRarity {

    @Override
    public int AffixChance() {
	return 80;
    }

    @Override
    public MinMax SecondaryStatsAmount() {
	return new MinMax(2, 4);
    }

    @Override
    public MinMax StatPercents() {
	return new MinMax(15, 90);
    }

    @Override
    public int SetChance() {
	return 50;
    }

    @Override
    public float specialItemChance() {
	return 6.5F;
    }

}
