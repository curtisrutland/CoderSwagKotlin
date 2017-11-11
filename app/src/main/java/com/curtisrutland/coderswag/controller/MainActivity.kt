package com.curtisrutland.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.curtisrutland.coderswag.R
import com.curtisrutland.coderswag.adapters.CategoryAdapter
import com.curtisrutland.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView.adapter = adapter

    }
}
