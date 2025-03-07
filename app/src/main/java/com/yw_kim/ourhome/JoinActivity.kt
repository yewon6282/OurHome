package com.yw_kim.ourhome

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val joinButton = findViewById<TextView>(R.id.join_button)
        val email = findViewById<TextView>(R.id.email_edit)
        val password = findViewById<TextView>(R.id.password_edit)
        val passwordCheck = findViewById<TextView>(R.id.password_check_edit)

        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        joinButton.setOnClickListener {
            if (password.text.toString() != passwordCheck.text.toString()) {
                Toast.makeText(this, "password incorrect", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "join failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}