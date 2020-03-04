package com.example.praktikummodul5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = ArrayList<User>()
    val listUsers = arrayOf(
        "Alpha",
        "Bravo",
        "Charlie",
        "Delta",
        "Echo",
        "Foxtrot",
        "Golf",
        "Hotel",
        "India",
        "Juliet"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecycleView.setHasFixedSize (true)
        mRecycleView.layoutManager = LinearLayoutManager( this)
        for (i in 0 until listUsers.size){
            list.add(User(listUsers.get(i)))
            if (listUsers.size - 1 == i){
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()
                mRecycleView.adapter = adapter
                adapter.setOnClickListener {
                    Toast.makeText(this, "Halo "+ listUsers[it] , Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}
