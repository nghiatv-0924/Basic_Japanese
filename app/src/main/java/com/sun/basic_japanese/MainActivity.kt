package com.sun.basic_japanese

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.sun.basic_japanese.base.BaseFragment
import com.sun.basic_japanese.base.HasNavigationManager
import com.sun.basic_japanese.base.NavigationManager
import com.sun.basic_japanese.home.HomeFragment
import com.sun.basic_japanese.kanjiadvance.KanjiAdvanceFragment
import com.sun.basic_japanese.kanjibasic.KanjiBasicFragment
import com.sun.basic_japanese.kanjidetail.KanjiAdvanceDetailFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    HomeFragment.OnHomeFragmentInteractionListener,
    KanjiBasicFragment.OnKanjiBasicFragmentInteractionListener,
    KanjiAdvanceFragment.OnKanjiAdvanceFragmentInteractionListener,
    KanjiAdvanceDetailFragment.OnKanjiDetailFragmentInteractionListener,
    HasNavigationManager {

    private lateinit var navigationManager: NavigationManager
    private lateinit var currentFragment: BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        navigationManager = NavigationManager(supportFragmentManager, R.id.mainContainer)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: navigationManager.openAsRoot(HomeFragment.newInstance())
    }

    override fun setToolbarTitle(title: String) {
        collapsingToolbar?.title = title
    }

    override fun setToolbarVisibility(show: Boolean) {
        collapsingToolbar?.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun setCurrentFragment(fragment: BaseFragment) {
        currentFragment = fragment
    }

    override fun scroll(input: Int) {
        mainContainer.fullScroll(input)
    }

    override fun provideNavigationManager() = navigationManager
}
