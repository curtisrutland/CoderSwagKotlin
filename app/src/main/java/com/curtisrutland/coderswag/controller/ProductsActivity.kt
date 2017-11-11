package com.curtisrutland.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.curtisrutland.coderswag.R
import com.curtisrutland.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        Log.i("CATEGORY TYPE", categoryType)
        titleTxt.text = categoryType
    }
}
