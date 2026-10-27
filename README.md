# Jarvis - Android AI Assistant

A native Android app (Kotlin/Jetpack Compose) inspired by Jarvis, acting like an intelligent personal assistant with routines, automation, and auto-control capabilities.

## Features

- **Routines Engine**: Create automated routines triggered by time, location, WiFi, Bluetooth, battery state, and more
- **Auto-Control**: Automatically toggle WiFi, Bluetooth, DND, volume, and other device settings
- **Local-First**: All data stored locally with Room database for privacy and reliability
- **Material You**: Modern UI with dynamic theming following Material Design 3
- **Widget Support**: Quick access to routines from home screen (planned)
- **Action History**: Transparent logging of all automated actions

## Architecture

- **UI**: Jetpack Compose with Material 3
- **DI**: Hilt for dependency injection
- **Database**: Room (SQLite) for local persistence
- **Background Work**: WorkManager for reliable task execution
- **Navigation**: Navigation Compose

## Setup

1. Open the project in Android Studio (Arctic Fox or later)
2. Sync Gradle files
3. Run on a device or emulator (API 26+)

## Permissions

The app may request the following permissions:
- Location (for geofencing)
- WiFi/Bluetooth control
- Notification access
- Do Not Disturb access
- Exact alarms

All permissions are requested at point-of-use with clear explanations.

## Building

`ash
./gradlew assembleDebug
`

## Notes

- This app is designed local-first. PostgreSQL integration is not included by default.
- Some automation features may be limited by Android's background restrictions.
- For UI automation features, Accessibility Service must be enabled manually in Settings.
