package com.robertx22.db_lists;

import java.util.HashMap;

import com.robertx22.database.stat_types.UnknownStat;
import com.robertx22.database.stat_types.defense.Armor;
import com.robertx22.database.stat_types.defense.Dodge;
import com.robertx22.database.stat_types.defense.SpellDodge;
import com.robertx22.database.stat_types.elementals.all_damage.AllFireDamage;
import com.robertx22.database.stat_types.elementals.all_damage.AllNatureDamage;
import com.robertx22.database.stat_types.elementals.all_damage.AllThunderDamage;
import com.robertx22.database.stat_types.elementals.all_damage.AllWaterDamage;
import com.robertx22.database.stat_types.elementals.attack_damage.AttackFireDamage;
import com.robertx22.database.stat_types.elementals.attack_damage.AttackNatureDamage;
import com.robertx22.database.stat_types.elementals.attack_damage.AttackThunderDamage;
import com.robertx22.database.stat_types.elementals.attack_damage.AttackWaterDamage;
import com.robertx22.database.stat_types.elementals.pene.FirePene;
import com.robertx22.database.stat_types.elementals.pene.NaturePene;
import com.robertx22.database.stat_types.elementals.pene.ThunderPene;
import com.robertx22.database.stat_types.elementals.pene.WaterPene;
import com.robertx22.database.stat_types.elementals.resist.FireResist;
import com.robertx22.database.stat_types.elementals.resist.NatureResist;
import com.robertx22.database.stat_types.elementals.resist.ThunderResist;
import com.robertx22.database.stat_types.elementals.resist.WaterResist;
import com.robertx22.database.stat_types.elementals.spell_damage.SpellFireDamage;
import com.robertx22.database.stat_types.elementals.spell_damage.SpellNatureDamage;
import com.robertx22.database.stat_types.elementals.spell_damage.SpellThunderDamage;
import com.robertx22.database.stat_types.elementals.spell_damage.SpellWaterDamage;
import com.robertx22.database.stat_types.offense.ArmorPenetration;
import com.robertx22.database.stat_types.offense.CriticalDamage;
import com.robertx22.database.stat_types.offense.CriticalHit;
import com.robertx22.database.stat_types.offense.PhysicalDamage;
import com.robertx22.database.stat_types.offense.conversion.FireDamageConversion;
import com.robertx22.database.stat_types.offense.conversion.NatureDamageConversion;
import com.robertx22.database.stat_types.offense.conversion.ThunderDamageConversion;
import com.robertx22.database.stat_types.offense.conversion.WaterDamageConversion;
import com.robertx22.database.stat_types.resources.Energy;
import com.robertx22.database.stat_types.resources.EnergyRegen;
import com.robertx22.database.stat_types.resources.Health;
import com.robertx22.database.stat_types.resources.HealthRegen;
import com.robertx22.database.stat_types.resources.LifeOnHit;
import com.robertx22.database.stat_types.resources.Lifesteal;
import com.robertx22.database.stat_types.resources.Mana;
import com.robertx22.database.stat_types.resources.ManaOnHit;
import com.robertx22.database.stat_types.resources.ManaRegen;
import com.robertx22.database.stat_types.traits.Armored;
import com.robertx22.database.stat_types.traits.Elemental;
import com.robertx22.database.stat_types.traits.Golem;
import com.robertx22.database.stat_types.traits.Lucky;
import com.robertx22.database.stat_types.traits.Stealthy;
import com.robertx22.database.stat_types.traits.atronachs.EarthAtronach;
import com.robertx22.database.stat_types.traits.atronachs.FireAtronach;
import com.robertx22.database.stat_types.traits.atronachs.FrostAtronach;
import com.robertx22.database.stat_types.traits.atronachs.ThunderAtronach;
import com.robertx22.database.stat_types.traits.bad_and_good.Barbarian;
import com.robertx22.database.stat_types.traits.bad_and_good.ClumsyScholar;
import com.robertx22.database.stat_types.traits.bad_ones.Crippled;
import com.robertx22.database.stat_types.traits.bad_ones.Diseased;
import com.robertx22.stats.Stat;

public class Stats {
	public static HashMap<String, Stat> All = new HashMap<String, Stat>() {
		{
			{

				put(UnknownStat.GUID, new UnknownStat());
				// Resources
				put(Health.GUID, new Health());
				put(HealthRegen.GUID, new HealthRegen());
				put(Lifesteal.GUID, new Lifesteal());
				put(LifeOnHit.GUID, new LifeOnHit());

				put(Mana.GUID, new Mana());
				put(ManaRegen.GUID, new ManaRegen());
				put(ManaOnHit.GUID, new ManaOnHit());

				put(Energy.GUID, new Energy());
				put(EnergyRegen.GUID, new EnergyRegen());
				// Resources

				put(Armor.GUID, new Armor());
				put(ArmorPenetration.GUID, new ArmorPenetration());
				put(CriticalDamage.GUID, new CriticalDamage());
				put(CriticalHit.GUID, new CriticalHit());
				put(PhysicalDamage.GUID, new PhysicalDamage());

				// Elemental
				put(SpellFireDamage.GUID, new SpellFireDamage());
				put(SpellWaterDamage.GUID, new SpellWaterDamage());
				put(SpellThunderDamage.GUID, new SpellThunderDamage());
				put(SpellNatureDamage.GUID, new SpellNatureDamage());

				put(AttackFireDamage.GUID, new AttackFireDamage());
				put(AttackWaterDamage.GUID, new AttackWaterDamage());
				put(AttackThunderDamage.GUID, new AttackThunderDamage());
				put(AttackNatureDamage.GUID, new AttackNatureDamage());

				put(AllFireDamage.GUID, new AllFireDamage());
				put(AllWaterDamage.GUID, new AllWaterDamage());
				put(AllThunderDamage.GUID, new AllThunderDamage());
				put(AllNatureDamage.GUID, new AllNatureDamage());

				put(FireResist.GUID, new FireResist());
				put(NatureResist.GUID, new NatureResist());
				put(WaterResist.GUID, new WaterResist());
				put(ThunderResist.GUID, new ThunderResist());

				put(FirePene.GUID, new FirePene());
				put(NaturePene.GUID, new NaturePene());
				put(WaterPene.GUID, new WaterPene());
				put(ThunderPene.GUID, new ThunderPene());
				// Elemental

				put(Dodge.GUID, new Dodge());
				put(SpellDodge.GUID, new SpellDodge());

				// traits
				put(Golem.GUID, new Golem());
				put(Elemental.GUID, new Elemental());
				put(Lucky.GUID, new Lucky());
				put(Barbarian.GUID, new Barbarian());
				put(Stealthy.GUID, new Stealthy());
				put(ClumsyScholar.GUID, new ClumsyScholar());
				put(Crippled.GUID, new Crippled());
				put(Diseased.GUID, new Diseased());
				put(Armored.GUID, new Armored());

				put(EarthAtronach.GUID, new EarthAtronach());
				put(FrostAtronach.GUID, new FrostAtronach());
				put(FireAtronach.GUID, new FireAtronach());
				put(ThunderAtronach.GUID, new ThunderAtronach());

				put(FireDamageConversion.GUID, new FireDamageConversion());
				put(WaterDamageConversion.GUID, new WaterDamageConversion());
				put(ThunderDamageConversion.GUID, new ThunderDamageConversion());
				put(NatureDamageConversion.GUID, new NatureDamageConversion());

				// traits

			}
		}
	};
}
