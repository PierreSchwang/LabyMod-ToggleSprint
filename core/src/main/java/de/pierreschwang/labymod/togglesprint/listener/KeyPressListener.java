package de.pierreschwang.labymod.togglesprint.listener;

import com.google.inject.Inject;
import de.pierreschwang.labymod.togglesprint.ToggleSprintAddon;
import de.pierreschwang.labymod.togglesprint.api.IClientAccessor;
import de.pierreschwang.labymod.togglesprint.state.States;
import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.input.KeyEvent;
import net.labymod.api.event.client.input.KeyEvent.State;

public class KeyPressListener {

  private final ToggleSprintAddon addon;
  private final IClientAccessor clientAccessor;

  @Inject
  public KeyPressListener(ToggleSprintAddon addon, IClientAccessor clientAccessor) {
    this.addon = addon;
    this.clientAccessor = clientAccessor;
  }

  @Subscribe
  public void onKeyPressed(KeyEvent event) {
    if (event.state() != State.PRESS) {
      return;
    }
    if (!addon.configuration().enabled().get()) {
      return;
    }
    if (!Laby.labyAPI().minecraft().isIngame()) {
      return;
    }
    // Handle toggle of sneak
    if (addon.configuration().toggleSneak().get() && event.key() == clientAccessor.sneakKey()) {
      States.SNEAK.set(!States.SNEAK.get());
      return;
    }
    // Handle toggle of sprint
    if (addon.configuration().toggleSprint().get() && event.key() == clientAccessor.sprintKey()) {
      States.SPRINT.set(!States.SPRINT.get());
    }
  }

}
