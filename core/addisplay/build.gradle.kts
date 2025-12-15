plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.hilt)
}

android {
    namespace = "com.google.samples.apps.nowinandroid.appodeal.addisplay"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
//    implementation(libs.play.services.ads)
    implementation(libs.appodeal.sdk)
}