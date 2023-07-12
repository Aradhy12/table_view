package com.example.table_view

import android.view.View
import android.widget.TextView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder

/**
 * Created by evrencoskun on 23/10/2017.
 */
class RowHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    @JvmField
    val row_header_textview: TextView

    init {
        row_header_textview = itemView.findViewById(R.id.row_header_container)
    }
    fun bindData(data: Cell?) {
        row_header_textview.text = data?.data.toString()
        row_header_textview.setSelectableBackground(data?.isSelected ?: false,R.color.sticky_color)
    }
}