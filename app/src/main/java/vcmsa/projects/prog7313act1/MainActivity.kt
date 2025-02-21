package vcmsa.projects.prog7313act1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnOne : Button
    private lateinit var etValOne : EditText
    private lateinit var etValTwo : EditText
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnOne = findViewById(R.id.button)
        etValOne = findViewById(R.id.etValOne)
        etValTwo = findViewById(R.id.etValTwo)
        tvResult = findViewById(R.id.tvResult)

        btnOne.setOnClickListener {
            val num1 = etValOne.text.toString().toDoubleOrNull()
            val num2 = etValTwo.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val sum = num1 + num2
                tvResult.text = "Result: $sum"
            } else {
                tvResult.text = "Please enter valid numbers"
            }
        }
    }
}