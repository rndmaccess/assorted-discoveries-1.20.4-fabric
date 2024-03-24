package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADHorsePlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADHorsePlushBlock> CODEC = createCodec(ADHorsePlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.5D, 0.0D, 0.5D, 11.5D,
            12.5, 15.5D);

    public ADHorsePlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADHorsePlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
