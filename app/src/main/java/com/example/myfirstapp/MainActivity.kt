package com.example.myfirstapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp.ui.theme.BlankFragment
import com.example.myfirstapp.ui.theme.MyfirstappTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.enterButton)
        val entemail = findViewById<EditText>(R.id.emailAddress)
        val entpassword = findViewById<EditText>(R.id.textPassword)
        button.setOnClickListener {
            val mail = entemail.text.toString()
            val password = entpassword.text.toString()
            val truemail = "magamed@gmail.com"
            val truepass = "123123"
            if (mail == truemail && password == truepass) {
                Toast.makeText(this, "Вы вошли в систему", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Неверная почта или пароль", Toast.LENGTH_LONG).show()
                AlertDialog.Builder(this)
                    .setTitle("Неверные данные")
                    .setMessage("Вы ввели неверную почту или пароль, нажмите кнопку ниже чтобы попробовать еще раз")
                    .setPositiveButton("Поробовать еще раз"){dialog, which ->
                        val clearpass = findViewById<EditText>(R.id.textPassword)
                        clearpass.text.clear()
                        val clearmail = findViewById<EditText>(R.id.emailAddress)
                        clearmail.text.clear()
                    }


        }
    }




}
}