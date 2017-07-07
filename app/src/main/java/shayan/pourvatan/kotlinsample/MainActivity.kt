package shayan.pourvatan.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)


        val stringList: MutableList<String> = mutableListOf()
        (0..100).mapTo(stringList) { "test $it" }


        recyclerView.adapter = MainAdapter(this, stringList)
    }
}



