package com.robertx22.exiled_lib.registry.empty_entries;

import com.robertx22.mine_and_slash.database.data.gearitemslots.bases.BaseGearType;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.SpellCastContext;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.cast_types.SpellCastType;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.configs.ImmutableSpellConfigs;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.configs.PreCalcSpellConfigs;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.bases.configs.SC;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class EmptySpell extends BaseSpell {

    public EmptySpell() {
        super(new ImmutableSpellConfigs() {

            @Override
            public SpellCastType castType() {
                return null;
            }

            @Override
            public SoundEvent sound() {
                return null;
            }

            @Override
            public Elements element() {
                return null;
            }
        });
    }

    @Override
    public BaseGearType.PlayStyle getPlayStyle() {
        return BaseGearType.PlayStyle.INT;
    }

    @Override
    public String GUID() {
        return "";
    }

    @Override
    public PreCalcSpellConfigs getPreCalcConfig() {
        PreCalcSpellConfigs p = new PreCalcSpellConfigs();
        p.set(SC.CAST_TIME_TICKS, 0, 0);
        return p;
    }

    @Override
    public List<ITextComponent> GetDescription(TooltipInfo info, SpellCastContext ctx) {
        return null;
    }

    @Override
    public Words getName() {
        return Words.Empty;
    }

}
