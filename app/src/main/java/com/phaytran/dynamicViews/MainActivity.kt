package com.phaytran.dynamicViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var layoutView:LinearLayout
    private lateinit var btnAddView:Button
    private lateinit var layoutFragment: FrameLayout
    var selectedBeforeView:View? = null
    lateinit var listData: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listData = getLisData()
        connectView()

    }

    private fun getLisData(): java.util.ArrayList<Data> {
        return arrayListOf(
            Data(1,"Tran Van Phay"),
            Data(2,"Phay Tran"),
            Data(3,"TVP")
        )
    }

    private fun connectView() {
        layoutView = findViewById(R.id.layoutViews)
        btnAddView = findViewById(R.id.btnAddView)
        layoutFragment = findViewById(R.id.layoutFragment)
        btnAddView.setOnClickListener{
            addView()
        }
    }

    private fun addView() {
        val itemView = layoutInflater.inflate(R.layout.item_view,null,false)
        val title = itemView.findViewById<TextView>(R.id.title)
        val close = itemView.findViewById<ImageView>(R.id.removeView)
        close.setOnClickListener { removeView(itemView) }
        itemView.setOnClickListener { visibilityView(itemView) }
        layoutView.addView(itemView)
        if(selectedBeforeView==null){
            selectedBeforeView = itemView
            findViewById<LinearLayout>(R.id.bar).visibility = View.VISIBLE
        }
    }

    private fun visibilityView(itemView: View) {
        itemView.findViewById<LinearLayout>(R.id.bar).visibility = View.VISIBLE
        selectedBeforeView!!.findViewById<LinearLayout>(R.id.bar).visibility = View.INVISIBLE
        selectedBeforeView = itemView
        loadFragment()
    }

    private fun loadFragment() {
        val transaction  = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutFragment,FragmentContent())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun removeView(view: View) {
        layoutView.removeView(view)
    }


}