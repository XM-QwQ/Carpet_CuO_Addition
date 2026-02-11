package carpet_cuo.mixins.EndPortalFrameCanBeMinedMixin;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(
            method = "getMiningSpeed",
            at = @At("HEAD"),
            cancellable = true
    )
    private void miningSpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (Carpet_CuOSettings.endPortalFrameCanBeMined && state.getBlock() == Blocks.END_PORTAL_FRAME) {
            ToolComponent tool = stack.get(DataComponentTypes.TOOL);
            if (tool == null) return;
            cir.setReturnValue(tool.getSpeed(Blocks.OBSIDIAN.getDefaultState()));
        }
    }
}