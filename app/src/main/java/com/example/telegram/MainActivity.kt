package com.example.telegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.databinding.ActivityMainBinding
import com.example.telegram.ui.fragments.ChatFragment
import com.example.telegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,
                ChatFragment()
            )
            .commit()

        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolBar)
        mAppDrawer.create()
    }

    fun initFields(){
        mToolBar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolBar)
    }
}
