package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADChickenPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADChickenPlushBlock> CODEC = createCodec(ADChickenPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 3.0D, 12.0D,
            11.0D, 13.0D);

    public ADChickenPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADChickenPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
