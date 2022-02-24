package com.example.primerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.example.primerapp.databinding.ActivityMainBinding
import android.app.Activity
import android.widget.Toast


open class MainActivity : AppCompatActivity() {

    var dataBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(dataBinding?.root)

        dataBinding?.idSend?.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                var value = dataBinding?.idParam?.text.toString()
                action = "com.example.segundaapp.MainActivity"
                val parametros = Bundle()
                parametros.putString("datos", value)
                putExtras(parametros)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}