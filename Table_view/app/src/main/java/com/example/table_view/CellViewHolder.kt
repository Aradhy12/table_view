package com.example.table_view;

import android.graphics.drawable.GradientDrawable
import android.view.View;
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
//TODO check setdata
/*
basically setcell me doubt hai
doubt line 25 what is layout param | line 20 cell_textview cell||.data tostri what is this
* */
public class CellViewHolder(itemView:View):AbstractViewHolder(itemView){
        private val cell_textview: TextView
        private val cell_container: LinearLayout
        init {
                cell_textview=itemView.findViewById(R.id.cell_data)
                cell_container = itemView.findViewById(R.id.cell_container)
        }
        fun setCell(cell: Cell?) {
                cell_textview.text = cell!!.data.toString()

                // If your TableView should have auto resize for cells & columns.
                // Then you should consider the below lines. Otherwise, you can ignore them.

                // It is necessary to remeasure itself.
                cell_container.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
                cell_textview.setSelectableBackground(cell.isSelected)
        }

        }
//TODO implement is selected
fun View.setSelectableBackground(isSelected:Boolean,@ColorRes backgroundColor: Int = R.color.white) {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(context.getColor(backgroundColor))
        if (isSelected) {
                val context = context
               //gradientDrawable.setStroke(context.resources.getDimensionPixelOffset(R.dimen.size_1),context.resources.getColor(R.color.purple_400))
                gradientDrawable.setStroke(context.resources.getDimensionPixelOffset(R.dimen.size_1),context.resources.getColor(R.color.purple_400))
                background = gradientDrawable
        }
        else {
                background = gradientDrawable
        }
}