package com.example.telegram.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.telegram.R
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener {
            sendCode()
        }
    }
    private fun sendCode(){
        if (register_input_phone_number.text.toString().isEmpty()){
            Toast.makeText(activity,"Введите номер телефона", Toast.LENGTH_SHORT).show()
        } else {
            fragmentManager?.beginTransaction()?.apply {
                addToBackStack(null)
                replace(R.id.registerDataContainer, EnterCodeFragment()).commit()
            }
        }
    }
}