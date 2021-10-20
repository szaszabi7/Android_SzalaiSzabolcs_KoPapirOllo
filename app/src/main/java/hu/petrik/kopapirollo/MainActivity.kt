package hu.petrik.kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewEmber : ImageView
    private lateinit var imageViewGep : ImageView
    private lateinit var textEmberEredmeny : TextView
    private lateinit var textGepEredmeny : TextView
    private lateinit var gombKo : Button
    private lateinit var gombPapir : Button
    private lateinit var gombOllo : Button
    private lateinit var random : Random

    private var gepRandom : Int = 0
    private var win : Int = 0
    private var lose : Int = 0
    private var draw : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();

        gombKo.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.rock)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                draw++
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                lose++
                textGepEredmeny.setText("Gép: " + lose)
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                win++
                textEmberEredmeny.setText("Ember: " + win)
            }
        }

        gombPapir.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.paper)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                win++
                textEmberEredmeny.setText("Ember: " + win)
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                draw++
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                lose++
                textGepEredmeny.setText("Gép: " + lose)
            }
        }

        gombOllo.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.scissors)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                lose++
                textGepEredmeny.setText("Gép: " + lose)
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                win++
                textEmberEredmeny.setText("Ember: " + win)
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                draw++
            }
        }
    }


    fun init() {
        imageViewEmber = findViewById(R.id.imageViewEmber)
        imageViewGep = findViewById(R.id.imageViewGep)
        textEmberEredmeny = findViewById(R.id.textEmberEredmeny)
        textGepEredmeny = findViewById(R.id.textGepEredmeny)
        gombKo = findViewById(R.id.gombKo)
        gombPapir = findViewById(R.id.gombPapir)
        gombOllo = findViewById(R.id.gombOllo)
        random = Random;
    }
}
