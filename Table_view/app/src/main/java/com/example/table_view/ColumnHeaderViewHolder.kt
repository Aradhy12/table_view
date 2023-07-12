package com.example.table_view
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.evrencoskun.tableview.ITableView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder
import com.zeel.aparecium.R
import com.zeel.aparecium.tableview.model.ColumnHeader

/**
 * Created by evrencoskun on 23/10/2017.
 */
class ColumnHeaderViewHolder(itemView: View, private val tableView: ITableView?) :
    AbstractSorterViewHolder(itemView) {
    private val column_header_container: ViewGroup
    private val column_header_textview: TextView

    init {
        column_header_textview = itemView.findViewById(R.id.column_header_textView)
        column_header_container = itemView.findViewById(R.id.column_header_container)
    }

    /**
     * This method is calling from onBindColumnHeaderHolder on TableViewAdapter
     */
    fun setColumnHeader(columnHeader: ColumnHeader?) {
        column_header_textview.text = columnHeader!!.data.toString()

        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can remove them.

        // It is necessary to remeasure itself.
        column_header_container.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        column_header_textview.setSelectableBackground(columnHeader.isSelected,R.color.sticky_color)
        column_header_textview.requestLayout()
    }

    companion object {
        private val LOG_TAG = ColumnHeaderViewHolder::class.java.simpleName
    }
    }
