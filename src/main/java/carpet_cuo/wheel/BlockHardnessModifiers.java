package carpet_cuo.wheel;

import carpet_cuo.Carpet_CuOSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.Optional;

public class BlockHardnessModifiers {
    public static Optional<Float> getHardness(Block block, BlockView world, BlockPos pos) {
        if (Carpet_CuOSettings.endPortalFrameCanBeMined && block == Blocks.END_PORTAL_FRAME) return Optional.of(Blocks.OBSIDIAN.getHardness());
        return Optional.empty();
    }
}