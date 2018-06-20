package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory

import android.app.Application
import drivechain.lifecycle.AppKernel
import drivechain.logger.Logger
import javax.inject.Inject
import drivechain.androidservices.AndroidApplicationModule
import drivechain.androidservices.AndroidCompatActivityModule
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ApplicationComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.DaggerApplicationComponent



class WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication: Application() {
    @Inject lateinit var appKernel: AppKernel
    @Inject lateinit var logger: Logger

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()

        applicationComponent.inject(this)

        appKernel.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        appKernel.onTerminate(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        appKernel.onLowMemory(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        appKernel.onTrimMemory(this, level)
    }

    private fun initAppComponent() {
        val builder = DaggerApplicationComponent.builder()
        builder.androidApplicationModule(AndroidApplicationModule(this))
        applicationComponent = builder.build()
    }
}