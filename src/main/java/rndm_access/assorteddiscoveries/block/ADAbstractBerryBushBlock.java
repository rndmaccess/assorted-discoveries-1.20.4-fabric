package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;

public abstract class ADAbstractBerryBushBlock extends SweetBerryBushBlock {
    public ADAbstractBerryBushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected abstract Item berryItem();

    protected abstract TagKey<EntityType<?>> mobsImmune();

    protected abstract boolean bushDamages();

    protected abstract boolean needsLightToGrow();

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);

        if (this.isBushMaxAge(age) || age > 1 && !isHoldingBoneMeal(player, hand)) {
            ItemStack berryStack = new ItemStack(this.berryItem(), this.getBerryAmount(world, age));

            dropStack(world, pos, berryStack);
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS,
                    1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResult.success(world.isClient());
        }
        return ActionResult.PASS;
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(this.berryItem());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.getType().isIn(this.mobsImmune())) {
            entity.slowMovement(state, new Vec3d(0.8D, 0.75D, 0.8D));

            if (this.bushDamages() && !world.isClient() && state.get(AGE) > 0
                    && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);

                if (d >= 0.003D || e >= 0.003D) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);

        if(!needsLightToGrow()) {
            growBush(age, state, world, pos);
        } else {
            if (age < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
                growBush(age, state, world, pos);
            }
        }
    }

    private static void growBush(int age, BlockState state, ServerWorld world, BlockPos pos) {
        BlockState blockState = state.with(AGE, age + 1);
        world.setBlockState(pos, blockState, 2);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
    }

    private boolean isBushMaxAge(int age) {
        return Objects.equals(age, 3);
    }

    private boolean isHoldingBoneMeal(PlayerEntity player, Hand hand) {
        return player.getStackInHand(hand).isOf(Items.BONE_MEAL);
    }

    private int getBerryAmount(World world, int age) {
        int amount = 1 + world.getRandom().nextInt(2);

        if(this.isBushMaxAge(age)) {
            return amount + 1;
        } else {
            return amount;
        }
    }
}
