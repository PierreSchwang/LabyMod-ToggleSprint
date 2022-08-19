package de.pierreschwang.labymod.togglesprint.state;

import org.jetbrains.annotations.Nullable;

public class SimpleBooleanStateHolder extends StateHolder<Boolean> {

  public SimpleBooleanStateHolder(Boolean baseValue, @Nullable String widgetId,
      String configurationPath) {
    super(baseValue, widgetId, configurationPath);
    addChangeListener((type, oldValue, newValue) -> updateWidgetVisibility(newValue));
  }

  /**
   * Tracks deactivation of sneak and sprint, and only sets the state to {@code false}, when the
   * setting is disabled
   * <br>
   * Handling {@code true} as well would be useless, as that would indicate, that the user has their
   * sprint toggled by pressing the sprint button, but only enabled the setting for it.
   */
  @Override
  public void configurationValueUpdated(Boolean newValue) {
    if (!newValue) {
      set(false);
    }
  }

}
