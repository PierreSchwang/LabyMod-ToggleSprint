package de.pierreschwang.labymod.togglesprint.impl.v1_8;

import com.google.inject.Singleton;
import de.pierreschwang.labymod.togglesprint.api.IClientAccessor;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.models.Implement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@Singleton
@Implement(IClientAccessor.class)
public class ClientAccessorImpl implements IClientAccessor {

  @Override
  public boolean sneaking() {
    return Minecraft.getMinecraft().thePlayer.isSneaking();
  }

  @Override
  public void setSneaking(boolean sneaking) {
    KeyBinding.setKeyBindState(
        Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(),
        sneaking
    );
  }

  @Override
  public boolean sprinting() {
    return Minecraft.getMinecraft().thePlayer.isSprinting();
  }

  @Override
  public boolean flying() {
    return !Minecraft.getMinecraft().thePlayer.onGround;
  }

  @Override
  public void setSprinting(boolean sprinting) {
    KeyBinding.setKeyBindState(
        Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(),
        sprinting
    );
  }

  @Override
  public void setFlySpeed(float speed) {
    Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(speed);
  }

  @Override
  public @NotNull Key sneakKey() {
    return byKeyBind(Minecraft.getMinecraft().gameSettings.keyBindSneak);
  }

  @Override
  public @NotNull Key sprintKey() {
    return byKeyBind(Minecraft.getMinecraft().gameSettings.keyBindSprint);
  }

  private Key byKeyBind(KeyBinding binding) {
    return Key.getByLegacyId(binding.getKeyCode());
  }

}
