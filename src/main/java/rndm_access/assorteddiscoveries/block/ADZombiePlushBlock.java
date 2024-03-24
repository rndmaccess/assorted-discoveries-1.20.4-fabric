package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADZombiePlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADZombiePlushBlock> CODEC = createCodec(ADZombiePlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.5D, 0.0D, 3.5D, 13.0D,
            12.5D, 12.5D);

    public ADZombiePlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADZombiePlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
