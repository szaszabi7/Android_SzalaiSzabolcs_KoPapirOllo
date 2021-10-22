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
    lateinit var gepHp1 : ImageView
    lateinit var gepHp2 : ImageView
    lateinit var gepHp3 : ImageView
    lateinit var gepHpArray : Array<ImageView>
    lateinit var jatekosHp1 : ImageView
    lateinit var jatekosHp2 : ImageView
    lateinit var jatekosHp3 : ImageView
    lateinit var jatekosHpArray : Array<ImageView>
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
    /*private var win : Int = 0
    private var lose : Int = 0*/
    private var draw : Int = 0
    private var gepHp : Int = 3
    private var jatekosHp : Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

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
                /*lose++
                textGepEredmeny.setText("Gép: ${lose}")*/
                jatekosHp--
                jatekosHpArray[jatekosHp].setImageResource(R.drawable.heart1)
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                /*win++
                textEmberEredmeny.setText("Ember: ${win}")*/
                gepHp--
                gepHpArray[gepHp].setImageResource(R.drawable.heart1)
                Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
                gameEnd()
            }
        }

        gombPapir.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.paper)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                /*win++
                textEmberEredmeny.setText("Ember: ${win}")*/
                gepHp--
                gepHpArray[gepHp].setImageResource(R.drawable.heart1)
                Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                draw++
                Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show()
                textViewDontetlen.setText("Döntetlek száma: ${draw}")
            } else {
                imageViewGep.setImageResource(R.drawable.scissors)
                /*lose++
                textGepEredmeny.setText("Gép: ${lose}")*/
                jatekosHp--
                jatekosHpArray[jatekosHp].setImageResource(R.drawable.heart1)
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                gameEnd()
            }
        }

        gombOllo.setOnClickListener() {
            imageViewEmber.setImageResource(R.drawable.scissors)
            gepRandom = random.nextInt(3)
            if (gepRandom == 0) {
                imageViewGep.setImageResource(R.drawable.rock)
                /*lose++
                textGepEredmeny.setText("Gép: ${lose}")*/
                jatekosHp--
                jatekosHpArray[jatekosHp].setImageResource(R.drawable.heart1)
                Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
                gameEnd()
            } else if (gepRandom == 1) {
                imageViewGep.setImageResource(R.drawable.paper)
                /*win++
                textEmberEredmeny.setText("Ember: ${win}")*/
                gepHp--
                gepHpArray[gepHp].setImageResource(R.drawable.heart1)
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
        gepHp1 = findViewById(R.id.gepHp1)
        gepHp2 = findViewById(R.id.gepHp2)
        gepHp3 = findViewById(R.id.gepHp3)
        jatekosHp1 = findViewById(R.id.jatekosHp1)
        jatekosHp2 = findViewById(R.id.jatekosHp2)
        jatekosHp3 = findViewById(R.id.jatekosHp3)
        imageViewEmber = findViewById(R.id.imageViewEmber)
        imageViewGep = findViewById(R.id.imageViewGep)
        /*textEmberEredmeny = findViewById(R.id.textEmberEredmeny)
        textGepEredmeny = findViewById(R.id.textGepEredmeny)*/
        textViewDontetlen = findViewById(R.id.textViewDontetlen)
        gombKo = findViewById(R.id.gombKo)
        gombPapir = findViewById(R.id.gombPapir)
        gombOllo = findViewById(R.id.gombOllo)
        random = Random;
        gepHpArray = arrayOf(
            gepHp1, gepHp2, gepHp3
        )
        jatekosHpArray = arrayOf(
            jatekosHp1, jatekosHp2, jatekosHp3
        )
    }

    fun gameEnd() {
        if (jatekosHp == 0) {
            var myAlert = AlertDialog.Builder(this)
                .setTitle("Vereség")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Igen", DialogInterface.OnClickListener { dialog, id ->
                    reset()
                }).setNegativeButton("Nem", DialogInterface.OnClickListener { dialog, id ->
                    finishAffinity()
                }).show()
        } else if (gepHp == 0) {
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
        gepHp = 3
        jatekosHp = 3
        draw = 0
        for (i in 0..gepHpArray.size-1) {
            gepHpArray[i].setImageResource(R.drawable.heart2)
        }
        for (i in 0..jatekosHpArray.size-1) {
            jatekosHpArray[i].setImageResource(R.drawable.heart2)
        }
        /*textEmberEredmeny.setText("Ember: ${win}")
        textGepEredmeny.setText("Gép: ${lose}")*/
        textViewDontetlen.setText("Döntetlek száma: ${draw}")
    }
}
