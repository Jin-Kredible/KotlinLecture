package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class TablayoutPagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_pager_simple)


        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLay = findViewById<TabLayout>(R.id.tabLayout)
    }
}

class ViewPagerAdapter( val layoutinf : LayoutInflater, val tabCount : Int) :PagerAdapter() {

    override fun getCount(): Int {
        return tabCount
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return true
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position) {
            0-> {
                val view = layoutinf.inflate(R.layout.first_fragment,container,false)
                container.addView(view)
                return view
            }

            1->  {
                val view = layoutinf.inflate(R.layout.activity_tab_layout_pager_new,container,false)
                container.addView(view)
                return view
            }

            else->  {
                val view = layoutinf.inflate(R.layout.first_fragment,container,false)
                container.addView(view)
                return view
            }
        }
    }


}