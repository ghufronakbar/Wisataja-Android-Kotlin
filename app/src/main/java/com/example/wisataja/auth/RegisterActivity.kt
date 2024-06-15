package com.example.wisataja.auth

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wisataja.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etRegisterEmail: TextInputEditText = findViewById(R.id.etRegisterEmail)
        val etRegisterNama: TextInputEditText = findViewById(R.id.etRegisterNama)
        val etRegisterKataSandi: TextInputEditText = findViewById(R.id.etRegisterKataSandi)
        val etRegisterKonfirmasiKataSandi: TextInputEditText =
            findViewById(R.id.etRegisterKonfirmasiKataSandi)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val vEmail = etRegisterEmail.text.toString()
            val vKataSandi = etRegisterKataSandi.text.toString()
            val vKonfirmasiKataSandi = etRegisterKonfirmasiKataSandi.text.toString()
            val vNama = etRegisterNama.text.toString()


            if (vEmail.isEmpty() || vKataSandi.isEmpty() || vKonfirmasiKataSandi.isEmpty() || vNama.isEmpty()) {
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