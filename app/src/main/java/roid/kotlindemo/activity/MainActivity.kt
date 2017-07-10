package roid.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import roid.kotlindemo.R
import roid.kotlindemo.adapter.AdapterDemo
import roid.kotlindemo.utils.Helper

/*Simple way to get ride of findviewbyId provided by kotlin*/
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterDemo.OnItemClickListener {

    private var toolbar: Toolbar? = null
    private var rcvDemo: RecyclerView? = null
    private var mAdapterDemo: AdapterDemo? = null
    private var arrData: ArrayList<String> = ArrayList();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews();
        setupView();
    }

    override fun onItemClick(position: Int) {
        Helper.toast(this, "Clicked item at position " + position)
    }

    override fun onButtonClick(position: Int) {
        Helper.toast(this, "Clicked button at position " + position)
    }

    private fun setupView() {
        setSupportActionBar(toolbar)
        for (i in 0..20)
            arrData.add("This is $i")

        rcvDemo?.layoutManager = LinearLayoutManager(this)
        mAdapterDemo = AdapterDemo(this, arrData, this)
        rcvDemo?.adapter = mAdapterDemo
        mAdapterDemo?.notifyDataSetChanged()
    }

    private fun findViews() {

        toolbar = findViewById(R.id.toolbar) as Toolbar
        rcvDemo = findViewById(R.id.rcvDemo) as RecyclerView
    }
}
