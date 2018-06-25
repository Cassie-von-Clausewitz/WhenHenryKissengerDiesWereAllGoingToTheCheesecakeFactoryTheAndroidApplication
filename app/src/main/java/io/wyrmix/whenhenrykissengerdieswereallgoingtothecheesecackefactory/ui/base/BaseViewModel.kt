package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.exceptions.Failure
import java.io.Serializable

/**
 * Created by Alexander Melton on 6/19/2018.
 */
abstract class BaseViewModel: ViewModel(), Serializable{
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}