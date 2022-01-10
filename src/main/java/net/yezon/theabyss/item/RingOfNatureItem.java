
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfNatureEvent;
import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@TheAbyss.Processor.Tag
public class RingOfNatureItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:ring_of_nature")
	public static final Item block = null;
	public RingOfNatureItem(TheAbyss instance) {
		super(instance, 150);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheAbyssItemGroup.tab).maxDamage(250).rarity(Rarity.UNCOMMON));
			setRegistryName("ring_of_nature");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
list.add(new StringTextComponent("\u18B1 8.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new StringTextComponent("\u00A7bAbility\u00A7f: Let grow everything in a 3x3 block square."));
list.add(new StringTextComponent("It uses \u00A7b8 percent somnium\u00A7f by default but can be improved with potions."));
list.add(new StringTextComponent(""));
list.add(new StringTextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ApplyRingOfNatureEvent.executeEvent($_dependencies);
			}
			return retval;
		}
	}
}