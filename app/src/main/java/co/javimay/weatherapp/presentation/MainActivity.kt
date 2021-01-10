package co.javimay.weatherapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import co.javimay.weatherapp.R
import co.javimay.weatherapp.utils.tabsNames
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val titles = arrayOf(tabsNames.TAB_MAP, tabsNames.TAB_HOME, tabsNames.TAB_HELP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.pager)
        viewPager.isUserInputEnabled = false
        tabLayout = findViewById(R.id.tab_layout)
        init()
    }

    private fun init() {
        supportActionBar!!.elevation = 0f
        viewPager.setAdapter(ViewPagerFragmentAdapter(this, titles))
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }

    private class ViewPagerFragmentAdapter(
        fragmentActivity: FragmentActivity,
        val titles: Array<String>
    ) :
        FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return MapFragment()
                1 -> return HomeFragment()
                2 -> return HelpFragment()
            }
            return HomeFragment()
        }

        override fun getItemCount(): Int {
            return titles.size
        }
    }

}