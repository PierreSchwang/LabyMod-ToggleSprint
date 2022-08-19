package de.pierreschwang.labymod.togglesprint.api;

import net.labymod.api.client.gui.screen.key.Key;
import org.jetbrains.annotations.NotNull;

/**
 * Scaffolding for accessing native minecraft player data
 */
public interface IClientAccessor {

  /**
   * Toggles the sneaking state for the player
   *
   * @param sneaking {@code true}, if the player should sneak, {@code false} otherwise.
   */
  void setSneaking(boolean sneaking);

  /**
   * Check if a player is currently sneaking
   *
   * @return {@code true}, if the player is sneaking, {@code false} otherwise.
   */
  boolean sneaking();

  void setSprinting(boolean sprinting);

  boolean sprinting();

  boolean flying();

  void setFlySpeed(float speed);

  default float baseFlySpeed() {
    return 0.05f;
  }

  @NotNull Key sneakKey();

  @NotNull Key sprintKey();

}
