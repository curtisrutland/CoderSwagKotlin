package com.curtisrutland.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.curtisrutland.coderswag.R
import com.curtisrutland.coderswag.model.Category

class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    /**
     * Remember this ViewHolder pattern for later!!!
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if(convertView == null) { //this is the first time we are loading this view, so we need to cache the resource Ids to avoid costly view inflation
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, convertView)
            holder = ViewHolder() //store them in this ViewHolder
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder //tag is a lot like it was in winforms; cache this in the view itself
        } else { //we've already loaded this particular view
            holder = convertView.tag as ViewHolder //so we just un-cache the view-holder
            categoryView = convertView
        }

        //fetch the category itself
        val category = categories[position]
        //find the resId matching the string name of the image
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        //set the text of the view to the title and the image to the resource
        holder.categoryName?.text = category.title
        holder.categoryImage?.setImageResource(resourceId)

        //and send back the completed view
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    //used for getting unique ids. not used in this app
    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder(var categoryImage: ImageView? = null, var categoryName: TextView? = null)
}