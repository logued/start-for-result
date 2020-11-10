package com.example.startactivityforresult

// MainActivity.kt     DL Nov2020

// Demonstrates creating a Bundle, adding extras to it, passing it to a
// Second Activity via Intent, and unpacking the extras from the Bundle
// in the SecondActivity.

// Demos using the StartActivityForResult standard Contract
// to retrieve data from the ThirdActivity

// Note that these lines MUST be added in the build.gradle (App module)
//implementation 'androidx.activity:activity-ktx:1.2.0-beta01'
//implementation 'androidx.fragment:fragment:1.3.0-beta01'

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    //using the StartActivityForResult standard Contract
    // register a lambda (block of code) to deal with the result when it returns from the
    // called activity
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data  //  intent data

            val name = data?.getStringExtra("name")
            val age = data?.getIntExtra("age",0)
            val height = data?.getDoubleExtra("height",0.0)
            Log.d("DL","Name=$name, Age=$age, Height:$height")

            val lottoNumbers = data?.getIntegerArrayListExtra("lottoNumbers")
            if (lottoNumbers != null) {
                for(num in lottoNumbers)
                    Log.d("DL","$num,")
            }
            val nums = data?.getDoubleArrayExtra("nums")
             if (nums != null) {
                for(x in nums)
                    Log.d("DL","$x,")
            }

            val list = data?.getStringArrayListExtra("names")
            if (list != null) {
                for(name in list)
                    Log.d("DL","$name")
            }
            //TODO
            // retrieve the array of strings and display in Log


            // Do something with the data
            // e.g. put it in a TextView or ImageView
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // load UI containing Button to call startSecondActivity()

        val startButton = findViewById(R.id.button_2) as Button

        startButton.setOnClickListener {
            startForResult.launch(Intent(this, ThirdActivity::class.java))
        }

    }

    // invoked from onClick attribute of button_1 in activity_main.xml
    fun startSecondActivity(v : View) {
        Log.d("DL","... in startSecondActivity()")

        // create Intent and putExtra() values into the bundle.
        //  val intent = Intent(this, SecondActivity::class.java)
        //  intent.putExtra("student_id","D0012345")
        // The above code can be expressed in a more Kotlin like way, as shown below

        // Instantiate the Intent object.
        // Use .appy to apply the (lambda) statements in the block to the Intent object (implicit this)
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