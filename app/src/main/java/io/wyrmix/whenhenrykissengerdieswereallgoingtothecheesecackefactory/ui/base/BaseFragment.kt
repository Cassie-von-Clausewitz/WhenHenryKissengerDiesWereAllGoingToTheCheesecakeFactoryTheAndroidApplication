package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import drivechain.androidservices.AndroidCompatActivityModule
import drivechain.lifecycle.AppKernel
import drivechain.logger.Logger
import inkapplications.android.layoutinjector.autoInflateContentView
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityModule
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.DaggerAware
import javax.inject.Inject


/**
 * Boilerplate fragment pre-configured to run framework utilities.
 *
 * This class should not be used for re-usable logic. Not all fragments must
 * extend this class, it is simply for convenience.
 */
abstract class BaseFragment: Fragment(), DaggerAware {

    @Inject lateinit var logger: Logger
    @Inject lateinit var appKernel: AppKernel

    val app get() = activity!!.application as WhenHenryKissengerDiesWereAllGoingToTheCheesecakeFactoryTheAndroidApplication
    val component: ActivityComponent by lazy { app.applicationComponent.newActivityComponent(ActivityModule(), AndroidCompatActivityModule(activity as AppCompatActivity)) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = autoInflateContentView(inflater, container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectSelf(component)
        appKernel.bindLifecycle(lifecycle)
    }
}