package com.google.samples.apps.nowinandroid.appodeal.addisplay.manager

import android.app.Activity
import android.content.Context

interface NiaAdManager {
    fun initialize(context: Context)
    fun showInterstitialAd(activity: Activity?, onAppodealAdClosed: () -> Unit)
    fun showBannerAd(activity: Activity?)
}