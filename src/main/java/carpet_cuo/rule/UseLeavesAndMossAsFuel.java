package carpet_cuo.rule;

import carpet_cuo.Carpet_CuOSettings;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Items;

public class UseLeavesAndMossAsFuel {
    public static void registerFuels(){
        if (Carpet_CuOSettings.useLeavesAndMossAsFuel){
            FuelRegistryEvents.BUILD.register((builder, context) -> {
                builder.add(Items.SPRUCE_LEAVES,300);
                builder.add(Items.FLOWERING_AZALEA_LEAVES,300);
                builder.add(Items.DARK_OAK_LEAVES,300);
                builder.add(Items.OAK_LEAVES,300);
                builder.add(Items.MANGROVE_LEAVES,300);
                builder.add(Items.JUNGLE_LEAVES,300);
                builder.add(Items.CHERRY_LEAVES,300);
                builder.add(Items.BIRCH_LEAVES,300);
                builder.add(Items.AZALEA_LEAVES,300);
                builder.add(Items.ACACIA_LEAVES,300);
                builder.add(Items.MOSS_BLOCK,300);
                builder.add(Items.MOSS_CARPET,50);
            });
        }
    }
}
