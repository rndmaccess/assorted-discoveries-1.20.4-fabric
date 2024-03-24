package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADSheepPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADSheepPlushBlock> CODEC = createCodec(ADSheepPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 2.0D, 12.0D,
            12.0D, 14.0D);

    public ADSheepPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADSheepPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}