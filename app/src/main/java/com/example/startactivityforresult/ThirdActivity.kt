package com.example.startactivityforresult

// This activity is called from the MainActivity
// using startActivityForResult.
// It simply adds data to the extras bundle of the Intent that will be returned
// to the parent activity.  We can add any number of extras.

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("DL", "ThirdActivity...in onCreate()")

        // Put values into the intent to be sent back to the
        // activity that started this activity (i.e. the parent)
        intent.putExtra("name", "Donald")
        intent.putExtra("age", 74)
        intent.putExtra("height", 1.89)

        val myArrayList = ArrayList<Int>()
        myArrayList.add(6)
        myArrayList.add(16)
        myArrayList.add(19)
        myArrayList.add(25)
        myArrayList.add(38)
        myArrayList.add(42)
        intent.putIntegerArrayListExtra("lottoNumbers",myArrayList)


        val arr = doubleArrayOf(1.11, 2.22, 3.33, 4.44, 5.55)
        intent.putExtra("nums", arr)
        setResult(RESULT_OK, intent)
        finish() // signal that this activity is finished and
                    // the intent can be returned to the parent
    }

}