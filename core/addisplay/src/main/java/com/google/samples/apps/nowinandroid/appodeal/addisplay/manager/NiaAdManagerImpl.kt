package com.google.samples.apps.nowinandroid.appodeal.addisplay.manager

import android.app.Activity
import android.content.Context
import android.util.Log
import com.appodeal.ads.Appodeal
import com.appodeal.ads.InterstitialCallbacks
import com.appodeal.ads.initializing.ApdInitializationError
import com.appodeal.ads.utils.Log.LogLevel
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.forEach

internal const val APP_KEY = "dc63c965e20a5c68fc95c1b01ced6a7e02102d9583a26576"
private const val placementName = "default"

@Singleton
class NiaAdManagerImpl @Inject constructor() : NiaAdManager {

    private val initialized = AtomicBoolean(false)

    override fun initialize(context: Context) {
        if (!initialized.compareAndSet(false, true)) return
        initAppodealSdk(context.applicationContext)
    }

    override fun showInterstitialAd(
        activity: Activity?,
        onAppodealAdClosed: () -> Unit,
    ) {
        if (Appodeal.canShow(Appodeal.INTERSTITIAL, placementName)) {
            Appodeal.show(activity!!, Appodeal.INTERSTITIAL, placementName)
            setInterstitialListeners(onAppodealAdClosed)
        } else {
            onAppodealAdClosed.invoke()
        }
    }

    internal fun setInterstitialListeners(onAppodealAdClosed: () -> Unit) {
        Appodeal.setInterstitialCallbacks(
            object : InterstitialCallbacks {
                override fun onInterstitialLoaded(isPrecache: Boolean) {
                }

                override fun onInterstitialFailedToLoad() {
                }

                override fun onInterstitialClicked() {
                }

                override fun onInterstitialShowFailed() {
                }

                override fun onInterstitialShown() {
                }

                override fun onInterstitialClosed() {
                    onAppodealAdClosed.invoke()
                }

                override fun onInterstitialExpired() {
                }
            },
        )
    }

    internal fun initAppodealSdk(context: Context) {
        //It should be removed before release
        Appodeal.setLogLevel(LogLevel.debug)
        Appodeal.setTesting(true)

        Appodeal.initialize(
            context = context,
            appKey = APP_KEY,
            adTypes = Appodeal.BANNER or Appodeal.INTERSTITIAL,
        ) { errors: List<ApdInitializationError>? ->
            if (!errors.isNullOrEmpty()) {
                errors.forEach {
                    Log.e("AdManagerImpl", "onInitializationFinished: ", it)
                }
            } else {
                Log.e("AdManagerImpl", "Appodeal SDK initialized successfully")
            }
        }
    }
}