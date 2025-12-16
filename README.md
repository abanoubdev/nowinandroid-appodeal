![Now in Android](docs/images/nia-splash.jpg "Now in Android")

<a href="https://play.google.com/store/apps/details?id=com.google.samples.apps.nowinandroid"><img src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" height="70"></a>

Now in Android App
==================

**Learn how this app was designed and built in the [design case study](https://goo.gle/nia-figma), [architecture learning journey](docs/ArchitectureLearningJourney.md) and [modularization learning journey](docs/ModularizationLearningJourney.md).**

This is the repository for the [Now in Android](https://developer.android.com/series/now-in-android)
app. It is a **work in progress** 🚧.

**Now in Android** This project extends Now in Android by integrating Appodeal ads in a modular and architecture-compliant way.

The app is currently in development. The `prodRelease` variant is [available on the Play Store](https://play.google.com/store/apps/details?id=com.google.samples.apps.nowinandroid).

# What was added

**core:addisplay module

Responsible for initializing the Appodeal SDK

Provides APIs to display banner and interstitial ads across the application

Keeps all ad-SDK–specific logic isolated from feature modules

**Dependency Injection

Introduced an AdManager abstraction

Bound the Appodeal implementation via Hilt to ensure a single, app-wide instance

**Application startup integration

Added core:addisplay to the app module

Initializes the Appodeal SDK once during application startup

**UI integration

Exposed ad UI components via core:addisplay

Added core:addisplay as an API dependency to the UI layer that renders the news feed

**News feed ads

Updated NewsFeed.kt

Enhanced LazyStaggeredGridScope.newsFeed() to:

Display a banner ad at the top of the feed

Show an interstitial ad when a news item is clicked

Keep ad rendering decoupled from business logic and feature state
