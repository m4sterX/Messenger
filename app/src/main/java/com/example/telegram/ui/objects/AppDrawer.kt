package com.example.telegram.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.R
import com.example.telegram.ui.fragments.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(private val mainActivity: AppCompatActivity, private val toolbar: Toolbar) {

    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create(){
        createHeader(mainActivity)
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(

                PrimaryDrawerItem()
                    .withIdentifier(100)
                    .withName(R.string.q1)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(101)
                    .withName(R.string.q2)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_lock_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(102)
                    .withName(R.string.q3)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_chat_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(103)
                    .withName(R.string.q4)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(104)
                    .withName(R.string.q5)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_local_phone_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(105)
                    .withName(R.string.q6)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_turned_in_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(106)
                    .withName(R.string.q7)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_settings_black_24dp),

                DividerDrawerItem(),

                PrimaryDrawerItem()
                    .withIdentifier(107)
                    .withName(R.string.q8)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_person_add_black_24dp),

                PrimaryDrawerItem()
                    .withIdentifier(108)
                    .withName(R.string.q9)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_help_black_24dp)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener{
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position){
                        7 ->  mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer,
                                SettingsFragment()
                            )
                            .commit()
                    }
                    return false
                }
            })
            .build()
    }

    private fun createHeader(mainActivity: AppCompatActivity) {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName(R.string.Test_name)
                    .withEmail(R.string.Test_Phone)
            ).build()
    }
}