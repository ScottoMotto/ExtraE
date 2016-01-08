package com.solidDoWant.ExtraE.gameObjects.gui;

import moze_intel.projecte.PECore;
import moze_intel.projecte.gameObjs.tiles.RelayMK1Tile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GUIRelayMK4 extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation(PECore.MODID.toLowerCase(), "textures/gui/relay3.png");
	private RelayMK1Tile tile;
	
	public GUIRelayMK4(Container container, RelayMK1Tile tile)
	{
		super(container);
		this.tile = tile;
		this.xSize = 212;
		this.ySize = 194;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal(tile.getInventoryName()), 38, 6, 4210752);
		this.fontRendererObj.drawString(Integer.toString(tile.displayEmc), 125, 39, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		//Emc bar progress
		int progress = tile.getEmcScaled(102);
		this.drawTexturedModalRect(x + 105, y + 6, 30, 195, progress, 10);
		
		//Klein start bar progress. Max is 30.
		progress = tile.getChargingEMCScaled(30);
		this.drawTexturedModalRect(x + 153, y + 82, 0, 195, progress, 10);
				
		//Burn Slot bar progress. Max is 30.
		progress = tile.getRawEmcScaled(30);
		drawTexturedModalRect(x + 101, y + 82, 0, 195, progress, 10);
	}	
}