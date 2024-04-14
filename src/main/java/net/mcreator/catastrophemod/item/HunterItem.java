
package net.mcreator.catastrophemod.item;

import net.minecraft.sounds.SoundEvent;
import java.util.function.Consumer;
import net.minecraft.client.model.Model;

public abstract class HunterItem extends ArmorItem {

	public HunterItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 10;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{2, 3, 4, 2}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 15;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.LEATHER), new ItemStack(Items.IRON_INGOT));
			}

			@Override
			public String getName() {
				return "hunter";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Helmet extends HunterItem {

		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("head", new Modelhunters_hat(Minecraft.getInstance().getEntityModels().bakeLayer(Modelhunters_hat.LAYER_LOCATION)).head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal(
					"\u00A76Full Set Bonus: \u00A77Press \u00A7aY \u00A77to enter a stealth mode that increases movement speed by \u00A7a20% \u00A77and makes your next attack deal \u00A7a20% \u00A77more damage after not being hit or attacking for 3 seconds"));
			list.add(Component.literal("\u00A77Increased \u00A7aRanged Damage \u00A77by \u00A7a10%"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "catastrophe_mod:textures/entities/hunters_hat_texture.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

	}

	public static class Chestplate extends HunterItem {

		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", new Modelhunter_chestplate(Minecraft.getInstance().getEntityModels().bakeLayer(Modelhunter_chestplate.LAYER_LOCATION)).body,
							"left_arm", new Modelhunter_chestplate(Minecraft.getInstance().getEntityModels().bakeLayer(Modelhunter_chestplate.LAYER_LOCATION)).left_arm, "right_arm",
							new Modelhunter_chestplate(Minecraft.getInstance().getEntityModels().bakeLayer(Modelhunter_chestplate.LAYER_LOCATION)).right_arm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
							new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal(
					"\u00A76Full Set Bonus: \u00A77Press \u00A7aY \u00A77to enter a stealth mode that increases movement speed by \u00A7a20% \u00A77and makes your next attack deal \u00A7a20% \u00A77more damage after not being hit or attacking for 3 seconds"));
			list.add(Component.literal("\u00A77Increased \u00A7aRanged Damage \u00A77by \u00A7a10%"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "catastrophe_mod:textures/entities/hunter_chestplate_texture.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

	}

	public static class Leggings extends HunterItem {

		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal(
					"\u00A76Full Set Bonus: \u00A77Press \u00A7aY \u00A77to enter a stealth mode that increases movement speed by \u00A7a20% \u00A77and makes your next attack deal \u00A7a20% \u00A77more damage after not being hit or attacking for 3 seconds"));
			list.add(Component.literal("\u00A77Increased \u00A7aRanged Damage \u00A77by \u00A7a10%"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "catastrophe_mod:textures/models/armor/hunter_armor__layer_2.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

	}

	public static class Boots extends HunterItem {

		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal(
					"\u00A76Full Set Bonus: \u00A77Press \u00A7aY \u00A77to enter a stealth mode that increases movement speed by \u00A7a20% \u00A77and makes your next attack deal \u00A7a20% \u00A77more damage after not being hit or attacking for 3 seconds"));
			list.add(Component.literal("\u00A77Increased \u00A7aRanged Damage \u00A77by \u00A7a10%"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "catastrophe_mod:textures/models/armor/hunter_armor__layer_1.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

	}

}
