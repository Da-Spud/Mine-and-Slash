package com.robertx22.database.stats.types;

import com.robertx22.enumclasses.Elements;
import com.robertx22.stats.FillableStat;

public class Health extends FillableStat {
	public Health() {
		this.StatMinimum = 20;
	}

	@Override
	public String Name() {
		return "Health";
	}

	@Override
	public boolean ScalesToLevel() {
		return true;
	}

	@Override
	public Elements Element() {
		return null;
	}

	@Override
	public boolean IsPercent() {
		return false;
	}
}