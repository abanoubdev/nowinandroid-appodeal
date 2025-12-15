/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.appodeal.addisplay.manager

import android.content.Context
import android.util.Log
import com.appodeal.ads.Appodeal
import com.appodeal.ads.initializing.ApdInitializationError
import com.appodeal.ads.utils.Log.LogLevel
import javax.inject.Inject
import kotlin.collections.forEach

internal const val APP_KEY = "dc63c965e20a5c68fc95c1b01ced6a7e02102d9583a26576"

class AdManagerImpl @Inject constructor() : AdManager {
    override fun initialize(
        context: Context,
        onAppodealSdkInitialized: () -> Unit,
    ) {
        Appodeal.setLogLevel(LogLevel.debug)
        Appodeal.setTesting(true)
        Appodeal.initialize(
            context = context,
            appKey = APP_KEY,
            adTypes = Appodeal.BANNER or Appodeal.INTERSTITIAL,
        ) { errors: List<ApdInitializationError>? ->
            if (errors.isNullOrEmpty()) {
                errors?.forEach {
                    Log.e("AdManagerImpl", "onInitializationFinished: ", it)
                }
            }
            onAppodealSdkInitialized.invoke()
        }
    }
}