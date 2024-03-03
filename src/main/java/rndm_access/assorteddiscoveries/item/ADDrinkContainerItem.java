package rndm_access.assorteddiscoveries.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ADDrinkContainerItem extends Item {
    private final Item emptyContainer;

    public ADDrinkContainerItem(Item.Settings settings) {
        super(settings);
        this.emptyContainer = Items.GLASS_BOTTLE;
    }

    public ADDrinkContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings);
        this.emptyContainer = emptyContainer;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.eatFood(world, stack);

        if (user instanceof PlayerEntity player && !player.isCreative()) {
            player.giveItemStack(new ItemStack(this.emptyContainer, 1));
        }
        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
