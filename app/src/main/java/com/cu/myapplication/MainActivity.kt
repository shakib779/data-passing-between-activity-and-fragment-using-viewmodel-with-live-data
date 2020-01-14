package com.cu.myapplication

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this)[ActivityFragmentViewModel::class.java]

        model.name.observe(this, Observer {
            if(it == "") {
                textViewActivity.text = "Hello World:: Nothing found"
            } else {
                textViewActivity.text = "Hello $it"
            }
        })

        buttonOpenFragment.setOnClickListener {
            if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {
                supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, BlankFragment())
                    .commit()
            }
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
