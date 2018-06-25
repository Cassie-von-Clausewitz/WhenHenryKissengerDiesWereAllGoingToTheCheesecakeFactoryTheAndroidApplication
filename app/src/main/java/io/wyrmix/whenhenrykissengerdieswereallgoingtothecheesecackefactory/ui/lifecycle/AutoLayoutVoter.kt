package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

class AutoLayoutVoter: LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }
}