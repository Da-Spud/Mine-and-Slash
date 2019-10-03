package com.robertx22.mine_and_slash.new_content_test.talent_tree;

import com.robertx22.mine_and_slash.database.stats.stat_types.core_stats.Intelligence;
import com.robertx22.mine_and_slash.database.stats.stat_types.offense.CriticalDamage;
import com.robertx22.mine_and_slash.database.stats.stat_types.offense.CriticalHit;
import com.robertx22.mine_and_slash.saveclasses.ExactStatData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;

public class PerkEffects {

    public static PerkEffect NOTHING = new PerkEffect(new ExactStatData(0, StatTypes.Flat, CriticalHit.GUID));

    public static PerkEffect SMALL_CRIT_HIT = new PerkEffect(new ExactStatData(2, StatTypes.Flat, CriticalHit.GUID));
    public static PerkEffect MEDIUM_CRIT_HIT = new PerkEffect(new ExactStatData(4, StatTypes.Flat, CriticalHit.GUID));
    public static PerkEffect BIG_CRIT_HIT = new PerkEffect(new ExactStatData(10, StatTypes.Flat, CriticalHit.GUID));

    public static PerkEffect SMALL_CRIT_DMG = new PerkEffect(new ExactStatData(3, StatTypes.Flat, CriticalDamage.GUID));
    public static PerkEffect MEDIUM_CRIT_DMG = new PerkEffect(new ExactStatData(5, StatTypes.Flat, CriticalDamage.GUID));
    public static PerkEffect BIG_CRIT_DMG = new PerkEffect(new ExactStatData(15, StatTypes.Flat, CriticalDamage.GUID));

    public static PerkEffect MAJOR_INT = new PerkEffect(new ExactStatData(10, StatTypes.Flat, Intelligence.GUID))
            .type(PerkType.MAJOR);

    public static PerkEffect BIG_INT = new PerkEffect(new ExactStatData(5, StatTypes.Flat, Intelligence.GUID))
            .type(PerkType.BIG);

}

