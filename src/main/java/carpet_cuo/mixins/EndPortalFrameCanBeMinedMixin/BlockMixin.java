package carpet_cuo.mixins.EndPortalFrameCanBeMinedMixin;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(
            method = "onBreak",
            at = @At("HEAD")
    )
    private void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        if (Carpet_CuOSettings.endPortalFrameCanBeMined && !world.isClient() && state.getBlock() instanceof EndPortalFrameBlock && !player.isCreative()) {
            ItemStack portalFrameStack = new ItemStack(Items.END_PORTAL_FRAME);
            ItemEntity itemEntity = new ItemEntity(
                    world,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    portalFrameStack
            );
            world.spawnEntity(itemEntity);
        }
    }
}
