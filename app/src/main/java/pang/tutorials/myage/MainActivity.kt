package pang.tutorials.myage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.myButton)
        val tvMyTextView = findViewById<TextView>(R.id.textView)
        var timesCliked = 0

        btnClickMe.setOnClickListener{
            timesCliked += 1

            tvMyTextView.text = timesCliked.toString()
            Toast.makeText(this, "Hey Dominik", Toast.LENGTH_LONG).show()
        }
    }
}