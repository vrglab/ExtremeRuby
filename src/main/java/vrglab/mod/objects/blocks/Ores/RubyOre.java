package vrglab.mod.objects.blocks.Ores;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import vrglab.mod.init.ItemInit;
import vrglab.mod.objects.blocks.BlockBase;

public class RubyOre extends BlockBase {



	public RubyOre(String name, Material material) {

		super(name, material);

		setSoundType(SoundType.METAL);

		setHardness(6.0F);

		setResistance(15.0F);

		setHarvestLevel("pickaxe", 2);

	}

	

	@Override

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {

		return ItemInit.RUBY;

	}

	

	@Override

	public int quantityDropped(Random rand) {

		int max = 4;

		int min = 1;

		return rand.nextInt(max) + min;

	}
}
