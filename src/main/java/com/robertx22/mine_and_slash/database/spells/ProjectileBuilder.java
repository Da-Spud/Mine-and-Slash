package com.robertx22.mine_and_slash.database.spells;

import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.world.World;

import java.util.function.Function;

public class ProjectileBuilder {

    BaseSpell spell;
    Function<World, AbstractArrowEntity> projectile;
    LivingEntity caster;

    public float apart = 3;
    public float shootSpeed = 1;
    public int projectilesAmount = 1;

    public ProjectileBuilder(BaseSpell spell, Function<World, AbstractArrowEntity> projectile, LivingEntity caster) {
        this.spell = spell;
        this.projectile = projectile;
        this.caster = caster;
    }

    public void cast() {
        World world = caster.world;

        if (projectilesAmount > 1) {

            float addYaw = 0;

            for (int i = 0; i < projectilesAmount; i++) {

                if (i < projectilesAmount / 2) {
                    addYaw -= apart / projectilesAmount;
                } else if (i == projectilesAmount / 2) {
                    addYaw = 0;
                } else if (i > projectilesAmount / 2) {
                    addYaw += apart / projectilesAmount;
                }
                AbstractArrowEntity en = (AbstractArrowEntity) SpellUtils.getSpellEntity(projectile.apply(world), spell, caster);
                SpellUtils.setupProjectileForCasting(en, caster, shootSpeed, caster.rotationPitch,
                    caster.rotationYaw + addYaw
                );
                caster.world.addEntity(en);

            }
        } else {
            AbstractArrowEntity en = (AbstractArrowEntity) SpellUtils.getSpellEntity(projectile.apply(world), spell, caster);
            SpellUtils.setupProjectileForCasting(en, caster, shootSpeed, caster.rotationPitch, caster.rotationYaw
            );
            caster.world.addEntity(en);
        }
    }

}
