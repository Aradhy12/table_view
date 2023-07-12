package com.example.table_view
import com.evrencoskun.tableview.filter.IFilterableModel
import com.evrencoskun.tableview.sort.ISortableModel

open class Cell(private val mId: String, var data: Any?,override var isSelected: Boolean = false) : ISortableModel, IFilterableModel,ISelectable
{
    private val mFilterKeyword: String
    init {
    mFilterKeyword = data.toString()
}

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getId(): String {
        return mId
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getContent(): Any? {
        return data
    }

    override fun getFilterableKeyword(): String {
        return mFilterKeyword
    }
}
interface ISelectable {
    var isSelected: Boolean
}