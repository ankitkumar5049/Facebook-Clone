package com.example.facebookclone.util

import android.app.DatePickerDialog
import android.content.Context
import android.widget.TextView
import com.example.facebookclone.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object GeneralUtils {
    fun formatDate(year: Int, month: Int, day: Int): String {
        val cal = Calendar.getInstance()
        cal.set(year, month - 1, day) // Month in Calendar is zero-based
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return dateFormat.format(cal.time)
    }

    fun changeDateFormat(inputDate: String, inputFormat: String, outputFormat: String): String {
        try {
            val inputDateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())
            val outputDateFormat = SimpleDateFormat(outputFormat, Locale.getDefault())

            val date = inputDateFormat.parse(inputDate)
            return outputDateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return inputDate
    }

    fun showDatePickerDialog(context: Context, setText: TextView) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context, R.style.DatePickerDialogTheme,
            { view, year, monthOfYear, dayOfMonth ->

                val selectedDate = formatDate(year, monthOfYear + 1, dayOfMonth)
                setText.text = selectedDate

                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, monthOfYear, dayOfMonth)

                if (selectedCalendar.after(Calendar.getInstance())) {
                    val currentDate = Calendar.getInstance()
                    setText.text = formatDate(
                        currentDate.get(Calendar.YEAR),
                        currentDate.get(Calendar.MONTH) + 1,
                        currentDate.get(Calendar.DAY_OF_MONTH)
                    )
                }

            }, year, month, day
        )

        datePickerDialog.show()
    }

}