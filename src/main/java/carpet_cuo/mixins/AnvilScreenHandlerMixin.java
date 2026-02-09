package carpet_cuo.mixins;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
    @Redirect(
            method = "updateResult",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/enchantment/Enchantment;getMaxLevel()I",
                    ordinal = 0
            )
    )
    private int RedirectMaxEnchantLevel(Enchantment enchantment) {
        if (Carpet_CuOSettings.noEnchantmentLevelLimit){
            return 114514;
        }else {
            return enchantment.getMaxLevel();
        }
    }
    @ModifyConstant(
            method = "updateResult",
            constant = @Constant(intValue = 40,ordinal = 2)
    )
    private int setLevelCost(int original){
        if (Carpet_CuOSettings.noTooExpensive){
            return 2147483647;
        }else {
            return original;
        }
    }
}
