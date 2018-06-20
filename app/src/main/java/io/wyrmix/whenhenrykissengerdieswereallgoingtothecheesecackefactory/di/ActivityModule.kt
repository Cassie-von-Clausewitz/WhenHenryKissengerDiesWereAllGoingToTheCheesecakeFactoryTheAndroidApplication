package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import drivechain.androidservices.ActivityScope
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bridge.debugdrawer.debugModulesOrderedBySimpleClassName
import io.palaima.debugdrawer.DebugDrawer
import io.palaima.debugdrawer.base.DebugModule

@ActivityScope @Module class ActivityModule {
    @Provides @ActivityScope fun debugDrawer(activity: AppCompatActivity, debugModules: Set<@JvmSuppressWildcards DebugModule>): DebugDrawer {
        return DebugDrawer.Builder(activity).modules(*debugModules.debugModulesOrderedBySimpleClassName()).build()
    }
}