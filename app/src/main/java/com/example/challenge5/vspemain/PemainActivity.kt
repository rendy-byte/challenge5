package com.example.challenge5.vspemain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.challenge5.R
import com.example.challenge5.controller.Controller
import com.example.challenge5.callback.CallBack

class pemainActivity : AppCompatActivity(), CallBack {
    private lateinit var imageStatus: ImageView
    private lateinit var refresh: ImageView
    private lateinit var close: ImageView
    private lateinit var pemain: TextView
    var Nama: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)

        imageStatus = findViewById(R.id.status)
        refresh = findViewById(R.id.refresh)
        val controller = Controller(this)
        close = findViewById(R.id.ivClose)


        var player1 = 0
        var player2 = 0
        var klikPlayer1: Boolean = true
        var klikPlayer2: Boolean = true

        val batu1 = findViewById<ImageView>(R.id.batu1)
        batu1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                batu1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                batu1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 1
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }
        val kt1 = findViewById<ImageView>(R.id.kt1)
        kt1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                kt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                kt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 2
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }
        val gt1 = findViewById<ImageView>(R.id.gt1)
        gt1.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                gt1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gunting))
                gt1.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player1 = 3
                klikPlayer1 = false
            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pemain 2 apa pilihanmu?", Toast.LENGTH_SHORT).show()
            }
        }


        //player 2
        val batu2 = findViewById<ImageView>(R.id.batu2)
        batu2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                batu2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.batu))
                batu2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 1
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih batu", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }
        val kt2 = findViewById<ImageView>(R.id.kt2)
        kt2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                kt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.kertas))
                kt2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 2
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih kertas", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }
        val gt2 = findViewById<ImageView>(R.id.gt2)
        gt2.setOnClickListener {
            if (klikPlayer1 && klikPlayer2) {
                Toast.makeText(this, "Player 1 apa pilihanmu?", Toast.LENGTH_SHORT).show()

            } else if (!klikPlayer1 && !klikPlayer2) {
                Toast.makeText(this, "Harap Reset Kembali", Toast.LENGTH_SHORT).show()
            } else {
                gt2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gunting))
                gt2.background = (ContextCompat.getDrawable(this, R.drawable.select))
                player2 = 3
                klikPlayer2 = false
                Toast.makeText(this, "Pemain 2 memilih gunting", Toast.LENGTH_SHORT).show()
                controller.bandingkanNumbers(player1, player2)
            }
        }



        refresh.setOnClickListener {
            batu1.background = (ContextCompat.getDrawable(this, R.drawable.batu))
            batu2.background = (ContextCompat.getDrawable(this, R.drawable.batu))
            kt1.background = (ContextCompat.getDrawable(this, R.drawable.kertas))
            kt2.background = (ContextCompat.getDrawable(this, R.drawable.kertas))
            gt1.background = (ContextCompat.getDrawable(this, R.drawable.gunting))
            gt2.background = (ContextCompat.getDrawable(this, R.drawable.gunting))
            imageStatus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vs))
            klikPlayer1 = true
            klikPlayer2 = true
        }


        // Permission Gilde
        val icon = findViewById<ImageView>(R.id.icon)
        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen%201.png")
            .into(icon)

        close.setOnClickListener {
            finish()
        }

        pemain = findViewById<TextView>(R.id.pemain)
        if (getIntent().getStringExtra("Name") != null) {
            Nama = getIntent().getStringExtra("Name");
            pemain.setText(Nama);
        }

    }

    override fun kirimStatus(status: String) {

        when {
            status.contains("1") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p1menang
                    )
                )

                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()
                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                val name = intent.getStringExtra("Name")
                hasilPemenang.setText(name + "\n MENANG!");

                val btnOk = view.findViewById<TextView>(R.id.tvBtnReplay)


                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<TextView>(R.id.tvBtnMenu)
                btnMenu.setOnClickListener {
                    finish()
                }
            }
            status.contains("2") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p2menang
                    )
                )

                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                intent.putExtra("cpu", "Pemain 2")
                val name = intent.getStringExtra("cpu")
                hasilPemenang.setText(name + "\n MENANG!");

                val btnOk = view.findViewById<TextView>(R.id.tvBtnReplay)


                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<TextView>(R.id.tvBtnMenu)
                btnMenu.setOnClickListener {
                    finish()
                }


            }
            status.contains("w") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.draw
                    )
                )

                // Custom Dialog
                val view = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null, false)
                val alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.setCancelable(false)

                val dialog = alert.create()
                dialog.show()

                val hasilPemenang = view.findViewById<TextView>(R.id.tvResult)
                intent.putExtra("seri", "SERI!")
                val name = intent.getStringExtra("seri")
                hasilPemenang.setText(name);

                val btnOk = view.findViewById<TextView>(R.id.tvBtnReplay)


                btnOk.setOnClickListener {
                    dialog?.dismiss()
                }

                val btnMenu = view.findViewById<TextView>(R.id.tvBtnMenu)
                btnMenu.setOnClickListener {
                    finish()
                }
            }
        }
    }
}