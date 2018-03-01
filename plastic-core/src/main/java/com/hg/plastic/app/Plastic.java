package com.hg.plastic.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by sfm on 2018-03-01.
 */

public class Plastic {
    public static Configurator init(Context context) {
        getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurator() {
        return Configurator.getInstance().getPlasticConfigs();
    }
}
