package com.lakshmi.mini_project.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lakshmi.mini_project.R

class SignUpAndLogInActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_and_log_in)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.Login->{
                val intent= Intent(this@SignUpAndLogInActivity,
                    LogInActivity::class.java)
                startActivity(intent)
            }
            R.id.sinup->{
                val intent=Intent(this@SignUpAndLogInActivity,
                    SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}