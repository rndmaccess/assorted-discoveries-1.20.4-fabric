package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADShortHatVillagerPlushBlock extends ADAbstractDirectionalPlushBlock {
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 3.5D, 13.0D,
            13.5D, 13.0D);

    public ADShortHatVillagerPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
