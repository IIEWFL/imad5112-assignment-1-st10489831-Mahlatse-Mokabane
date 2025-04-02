package vcmsa.ci.mealapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Chosen fields
    private lateinit var inputTxt: EditText
    private lateinit var recommendBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var dismissBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Code attribution
        //This method was taken from the
        //IMAD5112 Module Manual 2025
        //Page 41

        // Linking variables to id
        val showTxt = findViewById<TextView>(R.id.showTxt)
        inputTxt = findViewById(R.id.inputTxt)
        recommendBtn = findViewById(R.id.recommendBtn)
        resetBtn = findViewById(R.id.resetBtn)
        dismissBtn = findViewById(R.id.dismissBtn)

        // Assigning a Click Listener for the Recommend button
        recommendBtn.setOnClickListener {
            val inputTxtStr = inputTxt.text.toString().trim().lowercase() // Convert input to string and changes uppercase to lowercase

            //Code attribution
            //This method was taken from the
            // Tutors notes 2023
            //page 16
            if (inputTxtStr.isBlank()) { // Ensure inputTxt is converted properly
                inputTxt.error =
                    "Please enter the hour of the day" // Ensure inputTxt is an EditText
                showTxt.text = " " // Clear the text
            } else {
                val recommendFood = recommendFood(inputTxtStr) // function receives a string
                showTxt.text = "$recommendFood" // Display Recommendation
                inputTxt.error = null // Clear any previous error
            }
        }

        // Assigning a Click Listener for the Reset button
        resetBtn.setOnClickListener {
            inputTxt.text.clear()  // Clear the input field
            showTxt?.text = "" // Erase the current text

            //Code attribution
            //This method was taken from the
            // IMAD5112 Module Manual 2025
            //page 42
            Toast.makeText(this, "Reset successful!", Toast.LENGTH_SHORT).show() // Generate a toast message
        }
        // Assigning a Click Listener for the Dismiss button
        dismissBtn.setOnClickListener {
            // Close the Application
            finish()
        }
    }

    // Recommends foods based on the user's input
    private fun recommendFood(inputTxt: String): String {
        return when (inputTxt) {  // Gives you the ability to return a value based on varying conditions
            "morning" -> "Avocado toast with poached eggs"
            "before noon" -> "Smoothie bowl with granola"
            "afternoon" -> "Grilled Chicken Salad"
            "late afternoon" -> "Almond and Dark Chocolate"
            "dinner" -> "Oxtail with Mash Potatoes and Gravy"
            else -> "Invalid! Please enter time of day"


        }
    }
}
