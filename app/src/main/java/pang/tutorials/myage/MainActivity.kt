package pang.tutorials.myage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

   private var tvSelectedDate:TextView?=null
    private var tvTimesInMinute:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button =findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvTimesInMinute = findViewById(R.id.tvTimesInMinute)

        btnDatePicker.setOnClickListener(){

            clickDatePicker()


        }
    }

    private fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year =myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd =DatePickerDialog(this,
        {_, selectedYear, selectedyMonth, selectedyDayOfMonth ->
            Toast.makeText(this, "\n" +"Your birthdate" +
            " \"$selectedyDayOfMonth.${selectedyMonth + 1}.$selectedYear\"",Toast.LENGTH_LONG).show()

            val selectedDate="$selectedyDayOfMonth/${selectedyMonth+1}/$selectedYear"

            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            theDate?.let{
                val selectedDateInMinute = theDate.time  / 60000

                val currentData = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentData?.let{
                    val currentDataInMinutes = currentData.time / 60000

                    val differenceInMinutes = currentDataInMinutes - selectedDateInMinute

                    tvTimesInMinute?.text = differenceInMinutes.toString()
                }

            }


            },
            year,
            month,
            day

        )
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()

    }



}