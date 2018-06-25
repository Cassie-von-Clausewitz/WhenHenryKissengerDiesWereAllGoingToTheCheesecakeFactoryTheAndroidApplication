package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import inkapplications.android.layoutinjector.AutoLayout
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.R
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.databinding.MainFragmentBinding
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseFragment
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.withViewModel
import javax.inject.Inject

@AutoLayout(R.layout.main_fragment)
class MainFragment : BaseFragment() {

    @Inject lateinit var factory: ViewModelProvider.Factory

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = withViewModel(factory) {
//            observe(posts, ::updatePosts)
//            swipeRefreshLayout.setOnRefreshListener { get(refresh = true) }
        }

        val binding = MainFragmentBinding.bind(view!!)
        binding.viewmodel = viewModel
    }

    override fun onStart() {
        super.onStart()

        viewModel.getRoutes()
    }

    override fun injectSelf(component: ActivityComponent) = component.inject(this)
}
