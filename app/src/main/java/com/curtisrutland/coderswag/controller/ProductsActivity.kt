package com.curtisrutland.coderswag.controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.curtisrutland.coderswag.R
import com.curtisrutland.coderswag.adapters.ProductsAdapter
import com.curtisrutland.coderswag.services.DataService
import com.curtisrutland.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        val products = DataService.getProducts(categoryType)
        adapter = ProductsAdapter(this, products)

        val spanCount = when {
            resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE -> 3
            resources.configuration.screenWidthDp > 720 -> 3
            else -> 2
        }


        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter


        titleTxt.text = categoryType
    }
}
