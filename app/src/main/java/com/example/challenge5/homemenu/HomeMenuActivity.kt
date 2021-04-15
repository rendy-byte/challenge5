package com.example.challenge5.homemenu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge5.R
import com.example.challenge5.vscpu.cpuActivity
import com.example.challenge5.vspemain.pemainActivity
import com.google.android.material.snackbar.Snackbar


class homeMenuActivity : AppCompatActivity() {
    private lateinit var userPemain: TextView
    private lateinit var userPemain2: TextView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    var Nama: String? = null
    var Nama2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_menu)


        userPemain = findViewById<TextView>(R.id.userPemain)
        if (getIntent().getStringExtra("Name") != null) {
            Nama = getIntent().getStringExtra("Name");
            userPemain.setText(Nama + " " + "vs Pemain");

            Snackbar.make(
                findViewById(R.id.menu),
                "Selamat Datang $Nama",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Tutup") {
                    // Responds to click on the action

                }
                .show()
        }

        userPemain2 = findViewById<TextView>(R.id.userPemain2)
        if (getIntent().getStringExtra("Name") != null) {
            Nama2 = getIntent().getStringExtra("Name");
            userPemain2.setText(Nama2 + " " + "vs CPU");
        }

        img1 =findViewById(R.id.img1)
        img1.setOnClickListener {
            val intent = Intent(this@homeMenuActivity, pemainActivity::class.java)
            intent.putExtra("Name", Nama.toString())
            startActivity(intent)
        }

        img2 =findViewById(R.id.img2)
        img2.setOnClickListener {
            val intent = Intent(this@homeMenuActivity, cpuActivity::class.java)
            intent.putExtra("Name", Nama.toString())
            startActivity(intent)
        }



        /* val pemain = intent.getStringExtra("Name")
        Toast.makeText(this, "Name  $pemain", Toast.LENGTH_SHORT).show() */

    }
}

