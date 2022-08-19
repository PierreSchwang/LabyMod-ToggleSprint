package de.pierreschwang.labymod.togglesprint.listener;

import com.google.inject.Inject;
import de.pierreschwang.labymod.togglesprint.Constants;
import de.pierreschwang.labymod.togglesprint.ToggleSprintConfiguration;
import de.pierreschwang.labymod.togglesprint.api.IClientAccessor;
import de.pierreschwang.labymod.togglesprint.state.StateHolder;
import de.pierreschwang.labymod.togglesprint.state.States;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.labymod.config.SettingUpdateEvent;

public class SettingUpdateListener {

  private final IClientAccessor clientAccessor;

  @Inject
  public SettingUpdateListener(IClientAccessor clientAccessor) {
    this.clientAccessor = clientAccessor;
  }

  @Subscribe
  public void onSettingUpdate(SettingUpdateEvent event) {
    if (!(event.setting().getAccessor().config() instanceof ToggleSprintConfiguration)) {
      return;
    }
    String i18n = event.setting().getTranslationKey();
    // If addon gets disabled, disable all abilities (auto sneak, flight speed, ...)
    if (i18n.equalsIgnoreCase(Constants.I18N_KEY_SETTING_ENABLED)
        && event.getValue() == Boolean.FALSE) {
      States.SPRINT.set(false);
      States.SNEAK.set(false);
      this.clientAccessor.setFlySpeed(this.clientAccessor.baseFlySpeed());
      return;
    }
    // reset fly speed when disabling fly boost
    if (i18n.equalsIgnoreCase(Constants.I18N_KEY_SETTING_FLY_BOOST) &&
        event.getValue() == Boolean.FALSE) {
      this.clientAccessor.setFlySpeed(this.clientAccessor.baseFlySpeed());
      return;
    }
    // Pass through event to states
    for (StateHolder<?> state : States.ALL_STATES) {
      state.callConfigurationUpdated(event);
    }
  }

}
