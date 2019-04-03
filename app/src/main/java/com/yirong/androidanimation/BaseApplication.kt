package com.yirong.androidanimation

import android.app.Application
import android.net.http.HttpResponseCache.install
import me.yokeyword.fragmentation.Fragmentation

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Fragmentation.builder()
            // show stack view. Mode: BUBBLE, SHAKE, NONE
            .stackViewMode(Fragmentation.BUBBLE)
            .debug(BuildConfig.DEBUG)

        .install();

    }
}