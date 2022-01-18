package pang.tutorials.myage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.myButton)
        val textView1 = findViewById<TextView>(R.id.textView)

        btnClickMe.setOnClickListener{
            textView1.text = "Haha clik"
        }
    }
}