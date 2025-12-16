package com.google.samples.apps.nowinandroid.appodeal.addisplay.helper

import androidx.compose.runtime.staticCompositionLocalOf
import com.google.samples.apps.nowinandroid.appodeal.addisplay.manager.NiaAdManager
import com.google.samples.apps.nowinandroid.appodeal.addisplay.manager.NiaAdManagerImpl


val LocalAdManagersHelper = staticCompositionLocalOf<NiaAdManager> {
    NiaAdManagerImpl()
}
