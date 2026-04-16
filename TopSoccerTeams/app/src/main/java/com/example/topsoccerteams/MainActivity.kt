
package com.example.topsoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.util.Log.v
import java.util.Arrays

//logs the content of an array of strings
fun logArrayValues(arr: Array<String> , limit: Int = 0) {
    if (limit == 0) {
        Log.v("Array Values", Arrays.toString(arr))
    } else {
        Log.v("Array Values", Arrays.toString(
            arr.sliceArray(0..limit -1)))
    }
}
class MainActivity : AppCompatActivity() {

    // Teams from https://footballdatabase.com/ranking/south-africa/1
    // retrieved on 21 may 2022
    val teams =arrayOf<String>("Mamelodi sundowns FC",
        "Bidvest wits",
        "Orlando pirates",
        "Kaizer chiefs",
        "Cape town city FC")

    //looks for the shortest entry in a string array
    fun getshortestString(arr: Array<String>) : String {
        var shortestlength = 0
        var shortestElement = ""
        for (element in arr) {
            if (element.count() > shortestlength) {
            shortestlength = element.count()
            shortestElement = element
            }
        }
       return shortestElement
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //call the method to log array values
        logArrayValues(teams)
        logArrayValues(teams,2)

        //creating variable te hold textview tex
        val teamsTxt = findViewById<TextView>(R.id.teamsTxt)
        // assigning array content to a variable
        var teamDisplay = ""
        var count = 0

        //reassigned position of teams array to a new value
        teams[0] = "Mam sundowns FC :)"

        for (team in teams){
            teamDisplay += "${team}\n"
        }

        /*while (count < teams.count()) {
            teamDisplay += "${teams[count]}\n"
            count ++
        }
        teamDisplay += "${teams[0]}\n"
        teamDisplay += "${teams[1]}\n"
        teamDisplay += "${teams[2]}\n"
        teamDisplay += "${teams[3]}\n"
        teamDisplay += "${teams[4]}\n"*/

        //displaying array content in the textview
        teamsTxt.text = teamDisplay







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}