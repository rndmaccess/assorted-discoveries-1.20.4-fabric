package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class ADBatPlushBlock extends ADAbstractDirectionalPlushBlock {
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 4.0D, 15.0D,
            12.0D, 12.0D);

    public ADBatPlushBlock(AbstractBlock.Settings settings) {
        super(settings, NORTH_SHAPE);
    }
}
