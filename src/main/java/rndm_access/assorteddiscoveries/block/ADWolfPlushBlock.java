package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADWolfPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADWolfPlushBlock> CODEC = createCodec(ADWolfPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.5D, 0.0D, 2.5D, 11.5D,
            11.5D, 14.5D);

    public ADWolfPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADWolfPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
