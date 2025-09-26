package com.example.myfirstapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val debugLogin = findViewById<Switch>(R.id.switch2)
        val button = findViewById<Button>(R.id.enterButton)
        val entemail = findViewById<EditText>(R.id.emailAddress)
        val entpassword = findViewById<EditText>(R.id.textPassword)
        button.setOnClickListener {
            val mail = entemail.text.toString()
            val password = entpassword.text.toString()
            val truemail = "magamed@gmail.com"
            val truepass = "123123"
            intent.putExtra("userNm", mail)
            if (debugLogin.isChecked || mail == truemail && password == truepass) {
                Toast.makeText(this, "Вы вошли в систему", Toast.LENGTH_LONG).show()
                val nextActivity = Intent(this, MainActivity2::class.java)
                startActivity(nextActivity)

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