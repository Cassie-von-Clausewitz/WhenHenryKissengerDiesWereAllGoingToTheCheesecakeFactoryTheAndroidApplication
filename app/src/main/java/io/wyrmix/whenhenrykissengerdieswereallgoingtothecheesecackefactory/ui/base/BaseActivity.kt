package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.core.widget.toast
import dagger.Lazy
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.lifecycle.AppKernel
import drivechain.logger.ConsoleLogger
import drivechain.logger.Logger
import inkapplications.android.layoutinjector.autoInjectContentView
import io.palaima.debugdrawer.DebugDrawer
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityModule
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.DaggerAwareActivity
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), DaggerAwareActivity {
    @Inject lateinit var debugDrawer: Lazy<DebugDrawer>

    @Inject lateinit var logger: Logger
    @Inject lateinit var appKernel: AppKernel

    val app get() = application as WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication
    val component: ActivityComponent by lazy { app.applicationComponent.newActivityComponent(ActivityModule(), AndroidCompatActivityModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectSelf(component)
        appKernel.bindLifecycle(lifecycle)

        autoInjectContentView()

        try {
            debugDrawer.get()
        } catch (t: Throwable) {
            toast("Error in debug drawer")
            logger.error("Something went wrong initializing the debug drawer: [$t]")
        }
    }
}