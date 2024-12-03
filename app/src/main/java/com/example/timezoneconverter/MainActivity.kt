package com.example.timezoneconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.ZoneId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)  // Initialize ThreeTenABP library
        setContentView(R.layout.activity_main)

        val spinnerLocation1: Spinner = findViewById(R.id.spinnerLocation1)
        val spinnerLocation2: Spinner = findViewById(R.id.spinnerLocation2)
        val convertButton: Button = findViewById(R.id.convertButton)
        val timeDifferenceText: TextView = findViewById(R.id.timeDifferenceText)

        // Set up the spinner for selecting time zones
        val timeZones = ZoneId.getAvailableZoneIds().toList()
        val adapter = ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, timeZones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation1.adapter = adapter
        spinnerLocation2.adapter = adapter

        convertButton.setOnClickListener {
            val selectedTimeZone1 = spinnerLocation1.selectedItem.toString()
            val selectedTimeZone2 = spinnerLocation2.selectedItem.toString()

            // Get time difference in hours
            val timeDifference = TimeZoneHelper.getTimeDifferenceInHours(selectedTimeZone1, selectedTimeZone2)
            timeDifferenceText.text = "Time Difference: $timeDifference hours"

            // Get and display current times in each zone
            val timeInZone1 = TimeZoneHelper.getTimeInZone(selectedTimeZone1)
            val timeInZone2 = TimeZoneHelper.getTimeInZone(selectedTimeZone2)

            timeDifferenceText.append("\n$selectedTimeZone1 time: $timeInZone1")
            timeDifferenceText.append("\n$selectedTimeZone2 time: $timeInZone2")
        }
    }
}

