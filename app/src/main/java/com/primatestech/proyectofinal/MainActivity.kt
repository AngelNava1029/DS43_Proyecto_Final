package com.primatestech.proyectofinal

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var btnAddProduct: Button
    private lateinit var textViewPoints: TextView
    private lateinit var recyclerViewProducts: RecyclerView

    private var totalPoints = 0
    private val productList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextPrice = findViewById(R.id.editTextPrice)
        btnAddProduct = findViewById(R.id.btnAddProduct)
        textViewPoints = findViewById(R.id.textViewPoints)
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts)

        btnAddProduct.setOnClickListener {
            addProduct()
        }

        // Configurar RecyclerView
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        recyclerViewProducts.adapter = ProductAdapter(productList)
        val vegetablesWithPrices = mapOf(
            "Pepino" to 23.90,
            "Tomate" to 15.50,
            "Lechuga" to 10.00,
            "Zanahoria" to 12.20,
            "Calabacín" to 22.90,
            "Brócoli" to 16.40,
            "Espinaca" to 2.79,
            "Cebolla" to 8.99,
            "Chile" to 12.49,
            "Coliflor" to 13.29
        )

        vegetablesWithPrices.forEach { (vegetable, price) ->
            val defaultProduct = Product(vegetable, price)
            productList.add(defaultProduct)
        }

        // Notificar al adaptador sobre el cambio en la lista
        recyclerViewProducts.adapter?.notifyDataSetChanged()
    }

    private fun addProduct() {
        val name = editTextName.text.toString()
        val price = editTextPrice.text.toString().toDoubleOrNull()

        if (name.isNotEmpty() && price != null) {
            // Agregar producto a la lista
            productList.add(Product(name, price))

            // Actualizar puntos y limpiar campos
            totalPoints += calculatePoints(price)
            textViewPoints.text = "Puntos: $totalPoints"
            editTextName.text.clear()
            editTextPrice.text.clear()

            // Notificar al adaptador sobre el cambio en la lista
            recyclerViewProducts.adapter?.notifyDataSetChanged()
        }
    }

    private fun calculatePoints(price: Double): Int {
        // Puedes personalizar la lógica de cálculo de puntos según tus necesidades
        return (price * 10).toInt()
    }
}