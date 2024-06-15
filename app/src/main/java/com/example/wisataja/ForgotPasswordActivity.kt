package com.example.wisataja

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etPassword: TextInputEditText = findViewById(R.id.etPassword)
        val etConfirmPassword: TextInputEditText = findViewById(R.id.etConfirmPassword)
        val btnForgot: Button = findViewById(R.id.btnForgot)

        btnForgot.setOnClickListener {
            val vKataSandi = etPassword.text.toString()
            val vKonfirmasiKataSandi = etConfirmPassword.text.toString()


            if (vKataSandi.isEmpty() || vKonfirmasiKataSandi.isEmpty()) {
                showDialog(this, false)
            } else if (vKonfirmasiKataSandi != vKataSandi) {
                showDialog(this, false)
            } else if (vKonfirmasiKataSandi == vKataSandi) {
                showDialog(this, true)
            }
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
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        alertDialog.show()
    }
}