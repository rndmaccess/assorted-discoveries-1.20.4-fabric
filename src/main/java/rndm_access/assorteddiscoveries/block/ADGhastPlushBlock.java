package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADGhastPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADGhastPlushBlock> CODEC = createCodec(ADGhastPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 3.5D, 12.5D,
            10.0D, 12.5D);

    public ADGhastPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADGhastPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
