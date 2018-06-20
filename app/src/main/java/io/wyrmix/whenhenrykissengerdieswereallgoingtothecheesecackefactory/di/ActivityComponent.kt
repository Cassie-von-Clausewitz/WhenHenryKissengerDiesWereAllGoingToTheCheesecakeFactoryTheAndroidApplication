package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import android.app.Application
import android.support.v7.app.AppCompatActivity
import dagger.Component
import dagger.Subcomponent
import drivechain.androidservices.ActivityScope
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bridge.debugdrawer.DebugDrawerBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerLogsBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerOkHttpBridgeModule
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.MainActivity
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseActivity
import dagger.BindsInstance




@ActivityScope
@Subcomponent(modules = [
    AndroidCompatActivityModule::class,
    ActivityModule::class,
    DebugDrawerBridgeModule::class,
    DebugDrawerOkHttpBridgeModule::class,
    DebugDrawerLogsBridgeModule::class
])
interface ActivityComponent {

//    @Subcomponent.Builder interface Builder {
//        fun build(): ActivityComponent
////        @BindsInstance fun activity(activity: AppCompatActivity): Builder
//        @BindsInstance fun activityCompatModule(module: AndroidCompatActivityModule): Builder
//
//
//    }

    @Deprecated("This method is necessary to inject the base activity but\n" +
            "                  can't be used to inject child activities. This is deprecated\n" +
            "                  to indicate that you need to add a new method to this class\n" +
            "                  to inject your activity!")
    fun inject(target: BaseActivity)


//    @Deprecated("This method is necessary to inject the base fragment but\n" +
//            "                  can't be used to inject child fragments. This is deprecated\n" +
//            "                  to indicate that you need to add a new method to this class\n" +
//            "                  to inject your fragment!")
//    fun inject(target: BaseFragment)

    fun inject(target: MainActivity)
}