package carpet_cuo.mixins.BlockEntitySwapReintroducedMixin;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//#if MC >= 1.21.5
//$$@Mixin(BlockEntity.class)
//$$public class BlockEntityMixin {
//$$}
//#endif
//#if MC <= 1.21.4
@Mixin(BlockEntity.class)
public class BlockEntityMixin {
    @Inject(
            method = "validateSupports",
            at = @At("HEAD"),
            cancellable = true
    )
    private void skipValidateSupports(CallbackInfo ci){
        if (Carpet_CuOSettings.blockEntitySwapReintroduced){
            ci.cancel();
        }
    }
}
//#endif