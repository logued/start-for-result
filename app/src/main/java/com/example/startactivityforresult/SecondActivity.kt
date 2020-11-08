package com.example.startactivityforresult

//SecondActivity.kt  DL Nov2020

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Could load layout and then access it directly
// without need for findViewById()
//import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("DL", "SecondActivity...in onCreate()")

//        val intent = getIntent()        // get the Intent that was passed into this Activity
//        var bundle: Bundle? = intent.extras  // get the bundle of extras (? => nullable)
//        val id = bundle?.getString("student_id")
//        val name = bundle?.getString("student_name")
//        val age = bundle?.getInt("student_age")

        val id = intent.getStringExtra("student_id")
        val name = intent.getStringExtra("student_name")
        val age = intent.getIntExtra("student_age",0)  // return default 0 if no key present
        val height = intent.getDoubleExtra("student_height",0.0)

        // Capture the layout's TextView and set its text field
        val textView = findViewById<TextView>(R.id.textView_1).apply {
            text = id + "\n" + name + "\n" + age.toString() +"\n" + height
        }

//        val returnIntent = Intent()
//        returnIntent.putExtra("result", "Hey, I received your intent!")
//        setResult(RESULT_OK, returnIntent)
//        finish() // this finish method has to be called in order for the MainActivity to receive the result

    }

}