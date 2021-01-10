package co.javimay.weatherapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.javimay.weatherapp.presentation.help.ui.HelpFragment
import co.javimay.weatherapp.presentation.home.ui.HomeFragment
import co.javimay.weatherapp.presentation.map.ui.MapFragment

class ViewPagerFragmentAdapter(
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