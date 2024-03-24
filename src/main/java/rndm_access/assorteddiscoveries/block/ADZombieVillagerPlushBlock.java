package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADZombieVillagerPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADZombieVillagerPlushBlock> CODEC = createCodec(ADZombieVillagerPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.5D,
            12.5D, 13.5D);

    public ADZombieVillagerPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADZombieVillagerPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}