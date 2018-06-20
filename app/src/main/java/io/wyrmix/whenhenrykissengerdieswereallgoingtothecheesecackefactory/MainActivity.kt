package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory

import android.os.Bundle
import inkapplications.android.layoutinjector.AutoLayout
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseActivity
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.main.MainFragment

@AutoLayout(R.layout.main_activity)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    override fun injectSelf(component: ActivityComponent) = component.inject(this)
}
