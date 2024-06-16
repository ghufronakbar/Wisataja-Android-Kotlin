package com.example.wisataja.homefragment

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.cardview.widget.CardView
import com.example.wisataja.R
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class WishlistFragment : Fragment() {

    private lateinit var spinnerDestinasi: Spinner
    private lateinit var spinnerJam: Spinner
    private lateinit var destinasiList: Array<String>
    private lateinit var jamList: Array<String>
    private lateinit var etDate: TextInputEditText
    private lateinit var ivDatePicker: ImageView
    private lateinit var btnSimpan: Button
    private lateinit var cvResult: CardView
    private lateinit var etResultDestinasi: TextInputEditText
    private lateinit var etResultDate: TextInputEditText
    private lateinit var etResultJam: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wishlist, container, false)

        // Initialize Views
        spinnerDestinasi = view.findViewById(R.id.spinnerDestinasi)
        destinasiList = resources.getStringArray(R.array.destinasi)
        spinnerJam = view.findViewById(R.id.spinnerJam)
        jamList = resources.getStringArray(R.array.jam)
        etDate = view.findViewById(R.id.etDate)
        ivDatePicker = view.findViewById(R.id.ivDatePicker)
        btnSimpan = view.findViewById(R.id.btnSimpan)
        cvResult = view.findViewById(R.id.cvResult)
        etResultDestinasi = view.findViewById(R.id.etResultDestinasi)
        etResultDate = view.findViewById(R.id.etResultDate)
        etResultJam = view.findViewById(R.id.etResultJam)

        // Create an ArrayAdapter using the custom spinner item layout
        val destinasiAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item_layout, destinasiList)
        val jamAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item_layout, jamList)

        // Specify the layout to use when the list of choices appears
        destinasiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        spinnerDestinasi.adapter = destinasiAdapter
        spinnerJam.adapter = jamAdapter

        // Handle Date Picker
        ivDatePicker.setOnClickListener {
            showDatePicker()
        }

        // Handle Button Click
        btnSimpan.setOnClickListener {
            if (validateInputs()) {
                showDialog(requireContext(), true)

            } else {
                showDialog(requireContext(), false)
            }
        }

        return view
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                etDate.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
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
            if(isSuccess){
                updateResult()
                cvResult.visibility = View.VISIBLE
            }
        }

        alertDialog.show()
    }

    private fun validateInputs(): Boolean {
        val date = etDate.text.toString().trim()
        val jam = spinnerJam.selectedItem.toString().trim()
        val destinasi = spinnerDestinasi.selectedItem.toString().trim()

        return !(date.isEmpty() || jam == "Jam Berangkat dan Pulang" || destinasi == "Wisata Tujuan")
    }

    private fun updateResult() {
        val date = etDate.text.toString().trim()
        val jam = spinnerJam.selectedItem.toString().trim()
        val destinasi = spinnerDestinasi.selectedItem.toString().trim()

        etResultDate.setText(date)
        etResultJam.setText(jam)
        etResultDestinasi.setText(destinasi)
    }
}
