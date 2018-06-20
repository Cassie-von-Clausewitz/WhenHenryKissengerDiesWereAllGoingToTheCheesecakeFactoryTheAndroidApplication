package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import drivechain.activitycontainer.ActivityContainerModule
import drivechain.androidservices.AndroidApplicationModule
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bridge.debugdrawer.DebugDrawerBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerLogsBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerOkHttpBridgeModule
import drivechain.bridge.fresco.FrescoBridgeModule
import drivechain.bridge.okhttp.OkHttpBridgeModule
import drivechain.bridge.stetho.StethoBridgeModule
import drivechain.lifecycle.LifecycleModule
import drivechain.logger.AutoLoggers
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityContainerModule::class,
    AndroidApplicationModule::class,
    AppConfigModule::class,
    AndroidInjectionModule::class,
    AutoLoggers::class,
    StethoBridgeModule::class,
    OkHttpBridgeModule::class,
    FrescoBridgeModule::class,
    LifecycleModule::class])
interface ApplicationComponent {
    fun inject(target: WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication)

    fun newActivityComponent(module: ActivityModule, appCompatActivityModule: AndroidCompatActivityModule): ActivityComponent
}