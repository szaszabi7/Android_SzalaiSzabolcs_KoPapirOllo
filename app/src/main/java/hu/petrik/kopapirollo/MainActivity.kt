package hu.petrik.kopapirollo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewEmber : ImageView
    private lateinit var imageViewGep : ImageView
    private lateinit var textEmberEredmeny : TextView
    private lateinit var textGepEredmeny : TextView
    private lateinit var textViewDontetlen : TextView
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
                Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show()
                textViewDontetlen.setText("Döntetlek száma: ${draw}")
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                lose++
                textGepEredmeny.setText("Gép: ${lose}")
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                win++
                textEmberEredmeny.setText("Ember: ${win}")
                Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
                gameEnd()
            }
        }

        gombPapir.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.paper)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                win++
                Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
                textEmberEredmeny.setText("Ember: ${win}")
                gameEnd()
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                draw++
                Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show()
                textViewDontetlen.setText("Döntetlek száma: ${draw}")
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                lose++
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                textGepEredmeny.setText("Gép: ${lose}")
                gameEnd()
            }
        }

        gombOllo.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.scissors)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                lose++
                textGepEredmeny.setText("Gép: ${lose}")
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                win++
                textEmberEredmeny.setText("Ember: ${win}")
                Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                draw++
                Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show()
                textViewDontetlen.setText("Döntetlek száma: ${draw}")
            }
        }
    }


    fun init() {
        imageViewEmber = findViewById(R.id.imageViewEmber)
        imageViewGep = findViewById(R.id.imageViewGep)
        textEmberEredmeny = findViewById(R.id.textEmberEredmeny)
        textGepEredmeny = findViewById(R.id.textGepEredmeny)
        textViewDontetlen = findViewById(R.id.textViewDontetlen)
        gombKo = findViewById(R.id.gombKo)
        gombPapir = findViewById(R.id.gombPapir)
        gombOllo = findViewById(R.id.gombOllo)
        random = Random;
    }

    fun gameEnd() {
        if (lose == 3) {
            var myAlert = AlertDialog.Builder(this)
                .setTitle("Vereség")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Igen", DialogInterface.OnClickListener { dialog, id ->
                    reset()
                }).setNegativeButton("Nem", DialogInterface.OnClickListener { dialog, id ->
                    finishAffinity()
                }).show()
        } else if (win == 3) {
            var myAlert = AlertDialog.Builder(this)
                .setTitle("Győzelem")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Igen", DialogInterface.OnClickListener { dialog, id ->
                    reset()
                }).setNegativeButton("Nem", DialogInterface.OnClickListener { dialog, id ->
                    finishAffinity()
                }).show()
        }
    }

    fun reset() {
        imageViewEmber.setImageResource(R.drawable.rock)
        imageViewGep.setImageResource(R.drawable.rock)
        win = 0
        lose = 0
        draw = 0

        textEmberEredmeny.setText("Ember: ${win}")
        textGepEredmeny.setText("Gép: ${lose}")
        textViewDontetlen.setText("Döntetlek száma: ${draw}")
    }
}
