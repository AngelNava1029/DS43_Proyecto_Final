package com.primatestech.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {
    private var products : List<Product> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        initData()
        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.productRecycler
            )
        val adapter = ProductAdapter(products)
        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        products = listOf(

            Product(1, "pepino", "26.90", "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_Berenjena_300x.png?v=1556564528"),
            Product(2, "pepino", "26.90", "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_Berenjena_300x.png?v=1556564528"),
            Product(3, "pepino", "26.90", "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_Berenjena_300x.png?v=1556564528"),
            Product(4, "pepino", "26.90", "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_Berenjena_300x.png?v=1556564528")


        )
    }
}