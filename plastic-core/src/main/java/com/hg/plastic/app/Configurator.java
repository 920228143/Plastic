package com.hg.plastic.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by sfm on 2018-03-01.
 */

public class Configurator {
    private static final HashMap<String, Object> PLASTIC_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public final HashMap<String, Object> getPlasticConfigs() {
        return PLASTIC_CONFIGS;
    }

    public Configurator() {
        PLASTIC_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final void confiure() {
        initIcons();
        PLASTIC_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        PLASTIC_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) PLASTIC_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) PLASTIC_CONFIGS.get(key.name());
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
}
