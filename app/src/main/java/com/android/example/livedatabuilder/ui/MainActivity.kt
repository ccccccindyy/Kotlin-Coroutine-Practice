package com.android.example.livedatabuilder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.livedata.R
import com.android.example.livedatabuilder.ui.ui.main.CocktailListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CocktailListFragment.newInstance())
                .commitNow()
        }
    }
}