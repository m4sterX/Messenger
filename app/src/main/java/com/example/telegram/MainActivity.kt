package com.example.telegram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.activities.RegisterActivity
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

        initFields()
        initFunc()
    }

    private fun initFunc() {
        if(false) {
            setSupportActionBar(mToolBar)
            mAppDrawer.create()
            supportFragmentManager.beginTransaction()
                .replace(R.id.dataContainer,
                    ChatFragment()
                )
                .commit()
        } else {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun initFields(){
        mToolBar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolBar)
    }
}
