package com.dimalab.dimalabmod;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;

import static com.dimalab.dimalabmod.DimaLabMod.MODID;

public class DimaButton extends Button {
    int x;
    int y;
    int width;
    int height;
    ITextComponent text;

    public DimaButton(int x, int y, int width, int height, ITextComponent text, IPressable onPress) {
        super(x, y, width, height, text, onPress);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public ITextComponent getText() {
        return text;
    }


    @Override
    public void render(@Nonnull MatrixStack stack, int x, int y, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        FontRenderer fr = minecraft.font;
        stack.pushPose();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.defaultAlphaFunc();

        minecraft.getTextureManager().bind(new ResourceLocation(MODID, "textures/gui/book.jpg"));
        blit(stack, this.x + 20, this.y + 1, 0, isCursorAtDimaButton(x, y) ? this.height : 0, 16, this.height, 16, this.height * 2);

        stack.translate(0.0D, 0.0D, 120.0D);
        fr.draw(stack, this.text, this.x, this.y + this.height / 4f, 0xFFFFFF);

        stack.popPose();
    }

    public boolean isCursorAtDimaButton(int cursorX, int cursorY) {
        return cursorX >= this.x && cursorY >= this.y && cursorX <= this.x + this.width && cursorY <= this.y + this.height;
    }
}
