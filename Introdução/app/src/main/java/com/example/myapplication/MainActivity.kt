package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var numClicks: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<ConstraintLayout>(R.id.main)
        val editName = findViewById<EditText>(R.id.editName)
        val buttonChangeImage = findViewById<Button>(R.id.buttonChangeImage)
        val textResult = findViewById<TextView>(R.id.textResult)

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backgrounds = AppConfig.mainScreenBackgrounds

        buttonChangeImage.setOnClickListener {
            numClicks++
            mainLayout.setBackgroundResource(backgrounds[(numClicks - 1) % backgrounds.size])
            textResult.text = "${editName.text} $numClicks"
        }
    }
}
