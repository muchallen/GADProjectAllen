package com.example.gadprojectallen.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.gadprojectallen.LearningLeaders
import com.example.gadprojectallen.R
import com.example.gadprojectallen.SkillsIQLeaders

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
)
 private val Titles = arrayOf(
     "Learning Leaders",
     "Skills IQ Leaders"
 )
private  val Fragments = arrayOf<Fragment>(
  LearningLeaders(),
    SkillsIQLeaders()
)
/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1)
        return  Fragments[position]
    }

    override fun getPageTitle(position: Int)= Titles[position];

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}