package co.javimay.weatherapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import co.javimay.weatherapp.R
import co.javimay.weatherapp.presentation.adapter.ViewPagerFragmentAdapter
import co.javimay.weatherapp.utils.TAB_HELP
import co.javimay.weatherapp.utils.TAB_HOME
import co.javimay.weatherapp.utils.TAB_MAP
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val titles = arrayOf(
        TAB_MAP,
        TAB_HOME,
        TAB_HELP)

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
        viewPager.adapter = ViewPagerFragmentAdapter(this, titles)
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }
}