package com.example.startactivityforresult

// MainActivity.kt     DL Nov2020

// Demonstrates creating a Bundle, adding extras to it, passing it to a
// Second Activity via Intent, and unpacking the extras from the Bundle
// in the SecondActivity.

//DL2020
//https://developer.android.com/guide/components/activities/parcelables-and-bundles#kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // load UI containing Button to call startSecondActivity()
    }

    fun startSecondActivity(v : View) {
        Log.d("DL","... in startSecondActivity()")

        // create Intent and putExtra() values into the bundle.
        //  val intent = Intent(this, SecondActivity::class.java)
        //  intent.putExtra("student_id","D0012345")

        // The above code can be expressed in a more Kotlin like way, as shown below

        // Instantiate the Intent object.
        // Use .appy to apply the (lambdas) statements in the block to the Intent object (implicit this)
        // putExtra() acts on the Intent object and adds key value pairs to the Bundle object in the intent
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("student_id", "D00002020")
            putExtra("student_name", "James")
            this.putExtra("student_age",21)     // the 'this' is not needed as it is implicit
            this.putExtra("student_height", 1.88)
        }

            // The values above will be 'marshalled' so that they can be sent between the
            // two Activities

        startActivity(intent)   // Send Intent to Android asking to start the Second Activity

    }
}