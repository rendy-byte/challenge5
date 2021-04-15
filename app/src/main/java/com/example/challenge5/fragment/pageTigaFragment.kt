package com.example.challenge5.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.challenge5.R
import com.example.challenge5.homemenu.homeMenuActivity


class pageTigaFragment : Fragment() {
    private lateinit var userPemain : EditText
    private lateinit var userPemain2 : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_page_tiga, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.lanjut)
        val editText = view.findViewById<EditText>(R.id.edtname)


        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    imageView.visibility = View.VISIBLE
                } else {
                    imageView.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        userPemain=view.findViewById(R.id.edtname)

        imageView.setOnClickListener{
            val intent = Intent(activity, homeMenuActivity::class.java)
            intent.putExtra("Name", userPemain.text.toString())
            activity!!.startActivity(intent)
        }

        userPemain2=view.findViewById(R.id.edtname)

        imageView.setOnClickListener{
            val intent = Intent(activity, homeMenuActivity::class.java)
            intent.putExtra("Name", userPemain2.text.toString())
            activity!!.startActivity(intent)

        }

    }
}