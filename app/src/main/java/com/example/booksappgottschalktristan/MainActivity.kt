package com.example.booksappgottschalktristan

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
  private lateinit var inputEmail : EditText
  private lateinit var inputPassword: EditText
  private lateinit var preferences: SharedPreferences
  private var loggedIn: Boolean = false

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        // Authentification part
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        inputEmail = findViewById(R.id.emailInput)
        inputPassword = findViewById(R.id.passwordInput)
        preferences = getSharedPreferences("UserData", MODE_PRIVATE)
        val cacheEmail = preferences.getString("email","") ?: ""
        val cachePassword = preferences.getString("password", "") ?: ""
        if (cacheEmail != "" && cachePassword != "") {
                    auth.signInWithEmailAndPassword(cacheEmail, cachePassword)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                loggedIn = true
                                Toast.makeText(this, "Succès avec cache", Toast.LENGTH_LONG).show()

                            }
                        }
                    }
        }

    fun getValInput(editText: EditText): String {
        return editText.text.toString()
    }

    fun updateEmailPreference(email:String) {
        if (preferences.getString("email","")  == email) {
            Log.d("","L'email fournie est déjà stockée")
        } else {
            preferences.edit().putString("email", email).apply()
            Log.d("","L'email vient d'être stockée")
        }
    }

    fun updatePasswordPreference(password:String) {
        if (preferences.getString("password","")  == password) {
            Log.d("","Le mot de passe fourni est déjà stocké")
        } else {
            preferences.edit().putString("password", password).apply()
            Log.d("","Le mot de passe vient d'être stocké")

        }
    }

    fun goToListBooks () {
        val intent = Intent(this, ListBooksActivity::class.java)
        startActivity(intent)
    }

    fun onAuth(view: View) {
        val email = getValInput(inputEmail)
        val password = getValInput(inputPassword)
        if (email == ""){
            Toast.makeText(this, "Adresse mail doit être remplie", Toast.LENGTH_SHORT).show()
        } else if (password == "") {
            Toast.makeText(this, "Le mot de passe doit être rempli", Toast.LENGTH_SHORT).show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        updateEmailPreference(email)
                        updatePasswordPreference(password)
                        loggedIn = true
                        Toast.makeText(this, "Connexion réussie", Toast.LENGTH_LONG).show()
                        goToListBooks()
                    } else {
                        Toast.makeText(this, "Erreur d'email ou mot de passe", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }
}