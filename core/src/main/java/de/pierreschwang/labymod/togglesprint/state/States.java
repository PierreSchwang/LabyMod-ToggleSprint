package de.pierreschwang.labymod.togglesprint.state;

import de.pierreschwang.labymod.togglesprint.Constants;
import java.util.Set;
import org.spongepowered.include.com.google.common.collect.Sets;

public final class States {

  public static final StateHolder<Boolean> SNEAK = new SimpleBooleanStateHolder(
      false, "state_indicator_sneak", Constants.I18N_KEY_SETTING_TOGGLE_SNEAK
  );

  public static final StateHolder<Boolean> SPRINT = new SimpleBooleanStateHolder(
      false, "state_indicator_sprint", Constants.I18N_KEY_SETTING_TOGGLE_SPRINT
  );

  public static final Set<StateHolder<?>> ALL_STATES = Sets.newHashSet(SPRINT, SNEAK);

}
