package com.edu.uan.android.hw1_guessinggame


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class NumberGuessActivity : AppCompatActivity(), View.OnClickListener {
    private var editNumero: EditText? = null
    private var editBoton: Button? = null
    private var editEtiqueta: TextView? = null
    private var editBoton2: Button? = null

    private var numero: Number? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)

        editNumero = findViewById<EditText>(R.id.editTextNumber)
        editEtiqueta = findViewById<TextView>(R.id.textView3)

        editBoton = findViewById<Button>(R.id.button)
        editBoton?.setOnClickListener(this)

        editBoton2 = findViewById<Button>(R.id.button3)
        editBoton2?.setOnClickListener(this)
    }


    //Acá agrego los procesos para ejecutar en los botones
    var contador1 = 1
    private fun proceso(opc: Int?) {
        when (opc) {
            R.id.button -> {
                calculo()
                (contador1++)
            }
            R.id.button3 -> {
                reinicio()
                Toast.makeText(applicationContext, "Juego Reiniciado", Toast.LENGTH_SHORT).show()
            }
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //funcion principal
    var aleatorio: Long = (0..1000).random().toLong()

    private fun calculo() {

        println(aleatorio)
        if ((editNumero?.text.toString() != "")) {

            numero = editNumero?.text.toString().toLong()

            // numero = Integer.parseInt(editNumero?.text.toString())
            if (numero as Long > 0 && numero as Long <= 1000) {

                if (aleatorio > numero as Long) {
                    editEtiqueta?.text = "Digita un numero mayor"
                    Toast.makeText(applicationContext, "Digita un numero mayor", Toast.LENGTH_SHORT)
                        .show()

                } else {
                    editEtiqueta?.text = "Digita un numero menor"
                    Toast.makeText(applicationContext, "Digita un numero Menor", Toast.LENGTH_SHORT)
                        .show()
                }

                if (aleatorio === numero as Long) {
                    Toast.makeText(
                        applicationContext,
                        "Felicidades!! Lo adivinaste",
                        Toast.LENGTH_SHORT
                    ).show()
                    editEtiqueta?.text = "Felicidades lo lograste en ${contador1} intentos"
                }


            } else {
                editEtiqueta?.text = "Digite un numero entre 1 & 1000"
            }

        } else {
            editEtiqueta?.text = "Digita un numero valido"
        }


    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //reiniciar juego
    private fun reinicio() {
        if (editNumero?.text.toString().isEmpty()) {
            editNumero?.setText("")
            aleatorio = (0..1000).random().toLong()
            contador1 = 1
            editEtiqueta?.text = ""
        } else {

            editNumero?.setText("")
            aleatorio = (0..1000).random().toLong()
            contador1 = 1
            editEtiqueta?.text = ""

        }
    }

    override fun onClick(p0: View?) {
        proceso(p0?.id)
    }
}