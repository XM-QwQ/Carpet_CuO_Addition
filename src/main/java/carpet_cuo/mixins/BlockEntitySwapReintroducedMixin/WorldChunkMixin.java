package carpet_cuo.mixins.BlockEntitySwapReintroducedMixin;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

//#if MC >= 1.21.5
//$$@Mixin(WorldChunk.class)
//$$public abstract class WorldChunkMixin {
//$$}
//#endif
//#if MC <= 1.21.4
@Mixin(WorldChunk.class)
public abstract class WorldChunkMixin {
    @Redirect(
            method = "setBlockState",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/entity/BlockEntity;supports(Lnet/minecraft/block/BlockState;)Z"
            )
    )
    private boolean skipBlockEntityChecks(BlockEntity instance, BlockState state){
        if (Carpet_CuOSettings.blockEntitySwapReintroduced)return true;
        else return instance.supports(state);
    }
}
//#endif