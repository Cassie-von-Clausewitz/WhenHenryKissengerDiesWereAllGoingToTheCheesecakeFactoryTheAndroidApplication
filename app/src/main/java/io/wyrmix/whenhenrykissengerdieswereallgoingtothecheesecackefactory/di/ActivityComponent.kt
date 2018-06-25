package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di

import dagger.Subcomponent
import drivechain.androidservices.ActivityScope
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.bridge.debugdrawer.DebugDrawerBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerLogsBridgeModule
import drivechain.bridge.debugdrawer.DebugDrawerOkHttpBridgeModule
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.MainActivity
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseActivity
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseFragment
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.main.MainFragment
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders.OrdersActivity


@ActivityScope
@Subcomponent(modules = [
    AndroidCompatActivityModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    DebugDrawerBridgeModule::class,
    DebugDrawerOkHttpBridgeModule::class,
    DebugDrawerLogsBridgeModule::class
])
interface ActivityComponent {

    @Deprecated("This method is necessary to inject the base activity but\n" +
            "                  can't be used to inject child activities. This is deprecated\n" +
            "                  to indicate that you need to add a new method to this class\n" +
            "                  to inject your activity!")
    fun inject(target: BaseActivity)


    @Deprecated("This method is necessary to inject the base fragment but\n" +
            "                  can't be used to inject child fragments. This is deprecated\n" +
            "                  to indicate that you need to add a new method to this class\n" +
            "                  to inject your fragment!")
    fun inject(target: BaseFragment)

    fun inject(target: MainActivity)
    fun inject(target: MainFragment)
    fun inject(target: OrdersActivity)
}