package com.example.table_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.evrencoskun.tableview.adapter.AbstractTableAdapter

class MyTableViewAdapter : AbstractTableAdapter<ColumnHeader?,RowHeader?,Cell?>() {
  //done
    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val layout: View
        layout = inflater.inflate(R.layout.table_view_cell_layout, parent, false)
        return CellViewHolder(layout)
    }


    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItemModel: Cell,
        columnPosition: Int,
        rowPosition: Int
    ) {

        val cellViewHolder = holder as CellViewHolder
        cellViewHolder.setCell(cellItemModel)
    }
//creating class for column viewholder9
 override fun onCreateColumnHeaderViewHolder(parent :ViewGroup,viewType:Int):
 AbstractViewHolder
 {
     val layout = LayoutInflater.from(parent.context)
         .inflate(R.layout.table_view_column_header, parent, false)

     // Create a ColumnHeader ViewHolder
     return ColumnHeaderViewHolder(layout, tableView)
 }

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItemModel: ColumnHeader?,
        columnPosition: Int
    ) {
        val columnHeaderViewHolder = holder as ColumnHeaderViewHolder
        columnHeaderViewHolder.setColumnHeader(columnHeaderItemModel)
    }

    override fun onCreateRowHeaderViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        // Get Row Header xml Layout
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_row_header_layout, parent, false)

        // Create a Row Header ViewHolder
        return RowHeaderViewHolder(layout)
    }

    override fun getRowHeaderItemViewType(rowPosition: Int): Int {
        return 0
    }


    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder,
        rowHeaderItemModel: Any,
        rowPosition: Int
    ) {
        val rowHeader = rowHeaderItemModel as RowHeaderViewHolder
        rowHeader.bindData(rowHeaderItemModel)
    }
    override fun onCreateCornerView(parent: ViewGroup): View {
        // Get Corner xml layout
        val corner = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_view_corner_layout, parent, false)
        /**
        corner.setOnClickListener { view: View? ->
        val sortState = this@TableViewAdapter.tableView.rowHeaderSortingStatus
        if (sortState != SortState.ASCENDING) {
        Log.d("TableViewAdapter", "Order Ascending")
        this@TableViewAdapter.tableView.sortRowHeader(SortState.ASCENDING)
        } else {
        Log.d("TableViewAdapter", "Order Descending")
        this@TableViewAdapter.tableView.sortRowHeader(SortState.DESCENDING)
        }
        }
         **/
        return corner
    }
    override fun getColumnHeaderItemViewType(position: Int): Int {
        // The unique ID for this type of column header item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return 0
    }

    override fun getRowHeaderItemViewType(position: Int): Int {
        // The unique ID for this type of row header item
        // If you have different items for Row Header View by Y (Row) position,
        // then you should fill this method to be able create different
        // type of RowHeaderViewHolder on "onCreateRowHeaderViewHolder"
        return 0
    }

    override fun getCellItemViewType(column: Int): Int {

        // The unique ID for this type of cell item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return when (column) {
            else ->                 // Default view type
                0
        }
    }

    companion object {
        // Cell View Types by Column Position
        private const val MOOD_CELL_TYPE = 1
        private const val GENDER_CELL_TYPE = 2

        // add new one if it necessary..
        private val LOG_TAG = TableViewAdapter::class.java.simpleName
    }
}
