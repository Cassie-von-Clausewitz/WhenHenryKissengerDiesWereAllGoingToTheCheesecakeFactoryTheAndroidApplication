package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import dagger.Module
import dagger.Provides
import drivechain.appconfig.AppConfig
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.BuildConfig
import javax.inject.Singleton

@Module class AppConfigModule {
    @Provides @Singleton fun appConfig() = AppConfig(
            BuildConfig.DEBUG,
            BuildConfig.APPLICATION_ID,
            BuildConfig.VERSION_CODE,
            BuildConfig.VERSION_NAME,
            BuildConfig.BUILD_TYPE,
            BuildConfig.FLAVOR
    )
}