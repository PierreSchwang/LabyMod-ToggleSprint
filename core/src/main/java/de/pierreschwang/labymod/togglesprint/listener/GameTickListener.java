package de.pierreschwang.labymod.togglesprint.listener;

import com.google.inject.Inject;
import de.pierreschwang.labymod.togglesprint.ToggleSprintAddon;
import de.pierreschwang.labymod.togglesprint.api.IClientAccessor;
import de.pierreschwang.labymod.togglesprint.state.States;
import net.labymod.api.Laby;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.client.entity.player.GameMode;
import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;

public class GameTickListener {

  private final ToggleSprintAddon addon;
  private final IClientAccessor clientAccessor;

  @Inject
  public GameTickListener(ToggleSprintAddon addon, IClientAccessor clientAccessor) {
    this.addon = addon;
    this.clientAccessor = clientAccessor;
  }

  @Subscribe
  public void onTick(GameTickEvent event) {
    if (!addon.configuration().enabled().get()) {
      return;
    }
    if (!Laby.labyAPI().minecraft().isIngame()) {
      return;
    }
    if (event.phase() != Phase.PRE) {
      return;
    }
    // Toggle-Sneak is active and player should sneak, but doesn't
    if (States.SNEAK.get() && !clientAccessor.flying()) {
      clientAccessor.setSneaking(true);
      return;
    }
    // Toggle-Sprint is active and player should sprint, but doesn't
    if (States.SPRINT.get() && !clientAccessor.flying()) {
      clientAccessor.setSprinting(true);
      return;
    }
    ClientPlayer player = Laby.labyAPI().minecraft().clientPlayer();
    // Speed-Boost in creative mode
    if (addon.configuration().flyBoost().get() && player.gameMode() == GameMode.CREATIVE
        && player.isAbilitiesFlying() && clientAccessor.flying()) {
      clientAccessor.setFlySpeed(
          (float) (clientAccessor.baseFlySpeed() + (0.15 * addon.configuration()
              .flyBoostMultiplicity()
              .get()))
      );
    }
  }

}
