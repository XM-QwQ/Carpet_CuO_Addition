package carpet_cuo.mixins;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.block.ChainRestrictedNeighborUpdater;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChainRestrictedNeighborUpdater.class)
public abstract class ChainRestrictedNeighborUpdaterMixin {
    @Redirect(
            method = "enqueue",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/block/ChainRestrictedNeighborUpdater;maxChainDepth:I",
                    opcode = Opcodes.GETFIELD
            )
    )
    private int redirectMaxChainDepth(ChainRestrictedNeighborUpdater instance) {
        return Carpet_CuOSettings.maxChainDepth;
    }
    @Shadow
    private int depth;

    @Inject(
            method = "runQueuedUpdates",
            at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V", ordinal = 1)
    )
    private void depth(CallbackInfo ci) {
        if (Carpet_CuOSettings.showChainUpdateDepth && MinecraftClient.getInstance().player != null && depth>100000) {
            int a = depth-1;
            MinecraftClient.getInstance().player.sendMessage(Text.literal("Depth:" + a).formatted(Formatting.ITALIC, Formatting.GRAY), false);
        }
    }
}