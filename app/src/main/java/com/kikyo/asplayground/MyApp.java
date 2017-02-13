package com.kikyo.asplayground;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import timber.log.Timber;

/**
 * Created by shuailongcheng on 13/02/2017.
 */

public class MyApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            MultiDex.install(this);
        } catch (RuntimeException multiDexException) {
            // Work around Robolectric causing multi dex installation to fail, see
            // https://code.google.com/p/android/issues/detail?id=82007.
            //            if (!Utility.isUnderRoboletricTest()) {
            // Re-throw if this does not seem to be triggered by Robolectric.
            throw multiDexException;
            //            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
