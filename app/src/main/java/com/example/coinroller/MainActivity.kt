package com.example.coinroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //encontrar el Button
        val rollButton: Button = findViewById(R.id.button)
        //llamar a la funcion rollCoin() cuando se haga click en Botton
        rollButton.setOnClickListener{ rollCoin() }
    }

    private fun rollCoin() {
        //crear un nuevo objeto Coin con 2 lados
        val coin = Coin(2)

        val coinRoll = coin.roll()
        // encontrar ImageView en layout
        val coinImage: ImageView = findViewById(R.id.imageView)
        //determinar cuál drawale usar basado en el roll
        val drawableResource = when (coinRoll){
            1 -> R.drawable.coin_1
            else -> R.drawable.coin_2
        }
        //subir a ImagenView el correcto drawable
        coinImage.setImageResource(drawableResource)

        coinImage.contentDescription = coinRoll.toString()
    }
}
//clase de Coin con la funcion roll
class Coin(val numSides: Int){
    fun roll(): Int{ return (1..numSides).random() }
}