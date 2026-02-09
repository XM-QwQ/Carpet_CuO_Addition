package carpet_cuo.mixins.InfinitelyVaultMixin;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.vault.VaultServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(VaultServerData.class)
public class VaultServerDateMixin {
    @ModifyConstant(
            method = "markPlayerAsRewarded",
            constant = @Constant(intValue = 128)
    )
    private int modifyRewardedPlayersSize(int original){
        if (Carpet_CuOSettings.infinitelyVault){
            return 0;
        }else {
            return original;
        }
    }
}
