package com.example.wisataja

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvRegister: TextView = findViewById(R.id.tvRegister)
        val tvForgotPassword: TextView = findViewById(R.id.tvForgotPassword)
        val etLoginEmail: TextInputEditText = findViewById(R.id.etLoginEmail)
        val etLoginKataSandi: TextInputEditText = findViewById(R.id.etLoginKataSandi)
        val btnLoginSubmit: Button = findViewById(R.id.btnLoginSubmit)
        val ivLoginGoogle: ImageView = findViewById(R.id.ivLoginGoogle)

        btnLoginSubmit.setOnClickListener {
            val vEmail = etLoginEmail.text.toString()
            val vKataSandi = etLoginKataSandi.text.toString()

            if (vEmail.isEmpty() || vKataSandi.isEmpty()) {
                showDialog(this, false)
            } else if (vEmail == "user@example.com" && vKataSandi == "12345678") {
                showDialog(this, true)
            } else {
                showDialog(this, false)
            }
        }

        ivLoginGoogle.setOnClickListener {
                showDialogGoogle(this, true)
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun showDialog(context: Context, isSuccess: Boolean) {
        val dialogView = if (isSuccess) {
            layoutInflater.inflate(R.layout.layout_dialog_berhasil, null)
        } else {
            layoutInflater.inflate(R.layout.layout_dialog_gagal, null)
        }

        val alertDialog = AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }

        alertDialog.show()
    }

    private fun showDialogGoogle(context: Context, isSuccess: Boolean) {
        val dialogView = if (isSuccess) {
            layoutInflater.inflate(R.layout.layout_dialog_login_google, null)
        } else {
            layoutInflater.inflate(R.layout.layout_dialog_gagal, null)
        }

        val alertDialog = AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .setView(dialogView)
            .create()

        dialogView.findViewById<RelativeLayout>(R.id.profile1).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }
        dialogView.findViewById<RelativeLayout>(R.id.profile2).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }
        dialogView.findViewById<RelativeLayout>(R.id.profile3).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }
        dialogView.findViewById<RelativeLayout>(R.id.profile4).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }
        dialogView.findViewById<RelativeLayout>(R.id.profile5).setOnClickListener {
            alertDialog.dismiss()
            if (isSuccess) {
                layoutInflater.inflate(R.layout.layout_dialog_gagal, null)
            }
        }

        alertDialog.show()
    }
}
