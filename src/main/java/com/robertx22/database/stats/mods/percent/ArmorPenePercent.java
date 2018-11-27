package com.robertx22.database.stats.mods.percent;

import com.robertx22.database.stats.types.offense.ArmorPenetration;
import com.robertx22.stats.Stat;
import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public class ArmorPenePercent extends StatMod {

	public ArmorPenePercent() {
	}

	@Override
	public String GUID() {
		return "ArmorPenePercent";
	}

	@Override
	public int Min() {
		return 5;

	}

	@Override
	public int Max() {
		return 20;
	}

	@Override
	public StatTypes Type() {
		return StatTypes.Percent;
	}

	@Override
	public Stat GetBaseStat() {
		return new ArmorPenetration();
	}

}