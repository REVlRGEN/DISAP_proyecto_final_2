package mx.edu.uthermosillo.manuel.boletotren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo);

        logo.setOnClickListener {
            Toast.makeText(
                this,
                "¡Entrando...!",
                Toast.LENGTH_SHORT).show()

            val i = Intent(this, AuthActivity::class.java)
            startActivity(i)
        }
    }
}