package com.example.table_view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    private lateinit var tableView: TableView //build error
    private lateinit var adapter: TableViewAdapter
    private lateinit var adContainerView: FrameLayout

    private lateinit var toolbar: Toolbar
    private lateinit var saveView: Button
    private lateinit var viewElseWhere: Button
    private lateinit var editText: EditText
    private lateinit var tableViewListener: TableViewListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        adapter = TableViewAdapter()
       // editText = view!!.findViewById<EditText>(R.id.input_text)
        tableViewListener = TableViewListener(tableView, adapter, editText, gridViewModel)
      //  tableView.tableViewListener = tableViewListener //implement later eva implement
        adapter.setAllItems()
        tableView.setAdapter(adapter)

        }
    fun FRow(): ArrayList<String> {
        val numberList = ArrayList<String>()

        for (i in 1..10) {
            numberList.add(i.toString())
        }

        return numberList
    }
    fun FColumn(): ArrayList<String> {
        val numberList = ArrayList<String>()

        for (i in 1..10) {
            numberList.add(i.toString())
        }

        return numberList
    }

}
