package com.dimalab.dimalabmod;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.StringTextComponent;

import static com.dimalab.dimalabmod.DimaLabMod.MODID;


public class JustScreen extends Screen {
    protected JustScreen() {
        super(new StringTextComponent("DIMA SCREEN"));
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new DimaButton(0, 0, 20, 20, new StringTextComponent("button"), (button) -> {
            //Minecraft.getInstance().getTextureManager().bind(new ResourceLocation(MOD_ID, "textures/gui/book.jpg"));
            //Minecraft.getInstance().font.drawShadow(stack, 100, 100, new StringTextComponent("Just"), 0xFFFFFF);
            //private static void innerBlit(Matrix4f p_238461_e_, int p_238461_1_, int p_238461_2_)
        }));
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float i_dont_know_ticks_navernoe) {
        Minecraft.getInstance().getTextureManager().bind(new ResourceLocation(MODID, "textures/gui/dimascreen.png"));
        blit(stack, 110, 1, 0, 0, 315, 315, 315, 315);
        Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("Работает, не так ли?"), 110, 30, 0xFFFFFF);
       // Minecraft.getInstance().font.drawShadow(stack, new StringTextComponent("Screen"), 100, 10, 0xFFFFFF);
        //Minecraft.getInstance().font.drawShadow(stack, 100, 100, new StringTextComponent("Just"), 0xFFFFFF);
    }
}
