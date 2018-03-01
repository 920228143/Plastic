package com.hg.plastic.festec;

import android.app.Application;

import com.hg.plastic.app.Plastic;
import com.joanzapata.iconify.fonts.WeathericonsModule;

/**
 * Created by sfm on 2018-03-01.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Plastic.init(this)
                .withIcon(new WeathericonsModule())
                .withApiHost("http://127.0.0.1")
                .confiure();
    }
}
