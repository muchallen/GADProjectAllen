package com.example.gadprojectallen

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.gadprojectallen.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val submit:Button = findViewById(R.id.sub)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        submit.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
               val fm = supportFragmentManager;
                val fragment: Fragment = SubmissionFragment();
                val ft:FragmentTransaction= fm.beginTransaction();
                ft?.replace(R.id.frame,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }

        })



    }
}