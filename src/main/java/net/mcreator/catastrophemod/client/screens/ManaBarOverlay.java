
package net.mcreator.catastrophemod.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.catastrophemod.procedures.MsnsBar54Procedure;
import net.mcreator.catastrophemod.procedures.ManaBarFullProcedure;
import net.mcreator.catastrophemod.procedures.ManaBarEmptyProcedure;
import net.mcreator.catastrophemod.procedures.ManaBar9Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar8Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar7Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar6Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar5Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar57Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar56Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar55Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar53Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar52Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar51Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar50Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar4Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar49Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar48Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar47Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar46Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar45Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar44Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar43Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar42Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar41Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar40Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar3Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar39Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar38Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar37Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar36Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar35Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar34Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar33Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar32Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar31Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar30Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar2Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar29Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar28Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar27Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar26Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar25Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar24Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar23Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar22Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar21Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar20Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar1Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar19Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar18Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar17Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar16Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar15Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar14Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar13Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar12Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar11Procedure;
import net.mcreator.catastrophemod.procedures.ManaBar10Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (ManaBarEmptyProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_0.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_1.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_2.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_3.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_4.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_5.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_6.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_7.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_8.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_9.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_10.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_11.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_12.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_13.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_14.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_15.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_16.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_17.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_18.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_19.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar20Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_20.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar21Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_21.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar22Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_22.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar23Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_23.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar24Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_24.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar25Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_25.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar26Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_26.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar27Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_27.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar28Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_28.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar29Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_29.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar30Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_30.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar31Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_31.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar32Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_32.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar33Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_33.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar34Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_34.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar35Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_35.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar36Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_36.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar37Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_37.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar38Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_38.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar39Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_39.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar40Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_40.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar41Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_41.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar42Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_42.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar43Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_43.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar44Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_44.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar45Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_45.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar46Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_46.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar47Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_47.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar48Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_48.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar49Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_49.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar50Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_50.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar51Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_51.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar52Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_52.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar53Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_53.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (MsnsBar54Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_54.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar55Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_55.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar56Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_56.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBar57Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_57.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
			if (ManaBarFullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("catastrophe_mod:textures/screens/mana_bar_58.png"), w - 224, h - 35, 0, 0, 64, 16, 64, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
