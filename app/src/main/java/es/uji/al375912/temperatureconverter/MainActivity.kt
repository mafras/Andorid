package es.uji.al375912.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var celsiusEditText: EditText
    lateinit var fahrenheitEditText: EditText
    private var changing = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        celsiusEditText = findViewById(R.id.celsiusEditText)
        celsiusEditText.addTextChangedListener {
            if(!changing){
                changing = true
               onCelsiusChange(it.toString())
                changing = false

            }

        }
        fahrenheitEditText = findViewById(R.id.fahrenheitEditText)
        fahrenheitEditText.addTextChangedListener {
            if(!changing){
                changing = true
                onFahrenheitChange(it.toString())
                changing = false

            }
        }
    }

    private fun onFahrenheitChange(fahrenheitString: String) {
        val fahrenheit = fahrenheitString.toDoubleOrNull()
        if (fahrenheit == null)
            celsiusEditText.setText("")
        else {
            val celsius = fahrenheit -32 * 0.555
            celsiusEditText.setText(celsius.toString())
        }
    }

    private fun onCelsiusChange(celsiuString: String) {
        val celsius = celsiuString.toDoubleOrNull()
        if (celsius == null)
            fahrenheitEditText.setText("")
        else {
            val fahrenheit = celsius /100 *180 +32
            fahrenheitEditText.setText(fahrenheit.toString())
        }
    }
}