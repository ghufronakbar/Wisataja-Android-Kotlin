package com.example.wisataja.homefragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.wisataja.HomePageActivity
import com.example.wisataja.R
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProfileFragment : Fragment() {

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etDate: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        etName = view.findViewById(R.id.etName)
        etEmail = view.findViewById(R.id.etEmail)
        etPhone = view.findViewById(R.id.etPhone)
        etDate = view.findViewById(R.id.etDate)

        view.findViewById<Button>(R.id.btnSimpan).setOnClickListener {
            if (validateInputs()) {
                // All inputs are valid, proceed
                // For demonstration, assume success and show success dialog
                showDialog(requireContext(), true)
            } else {
                // At least one input is empty, show failure dialog
                showDialog(requireContext(), false)
            }
        }

        return view
    }

    private fun validateInputs(): Boolean {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val date = etDate.text.toString().trim()

        // Check if any of the fields are empty
        return !(name.isEmpty() || email.isEmpty() || phone.isEmpty() || date.isEmpty())
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
        }

        alertDialog.show()
    }
}
