package com.lakshmi.mini_project.Activites

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lakshmi.mini_project.R
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_sign_up.password

class LogInActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    var isRemembered=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        initviews()
    }
    private fun initviews(){
   sharedPreferences=getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)
        isRemembered=sharedPreferences.getBoolean("CHECKBOX",false)
        if(isRemembered){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        loginnext.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
  when(v?.id){
      R.id.loginnext-> {
          if (isDatavalid()) {
              val userName: String = Login.text.toString()
              val passWord: String = password.text.toString()
              val checked: Boolean = checkbox.isChecked
              val editor: SharedPreferences.Editor = sharedPreferences.edit()
              editor.putString("Name", userName)
              editor.putString("Password", passWord)
              editor.putBoolean("CHECKBOX", checked)
              editor.apply()
              Toast.makeText(this, "Information Saved!!", Toast.LENGTH_LONG).show()
              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)
              finish()
          }
      }
  }
    }
    private fun isDatavalid():Boolean{
        if(Login.text.toString().isEmpty()){
            Login.error="Please enter Username"
            return false
        }
        if(password.text.toString().isEmpty()){
            password.error="Please enter Password"
            return false
        }
        return true

    }
}