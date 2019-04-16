package com.robertx22.database.runewords.base.slots_5;

import java.util.Arrays;
import java.util.List;

import com.robertx22.customitems.runes.CenItem;
import com.robertx22.customitems.runes.ZohItem;
import com.robertx22.customitems.runes.base.BaseRuneItem;
import com.robertx22.database.runewords.base.RuneWord;
import com.robertx22.database.stat_mods.flat.CriticalDamageFlat;
import com.robertx22.database.stat_mods.flat.CriticalHitFlat;
import com.robertx22.database.stat_mods.flat.resources.HealthFlat;
import com.robertx22.database.stat_mods.spell_buffs.HomingFlat;
import com.robertx22.stats.StatMod;

public class RuneWordHoming extends RuneWord {

    @Override
    public List<StatMod> mods() {
	return Arrays.asList(new HomingFlat(), new CriticalHitFlat(), new CriticalDamageFlat(), new HealthFlat());
    }

    @Override
    public String name() {
	return "Homing";
    }

    @Override
    public List<BaseRuneItem> runes() {
	return Arrays.asList(new ZohItem(0), new CenItem(0)/* , new XahItem(0), new BerItem(0), new RahItem(0) */);
    }

}
