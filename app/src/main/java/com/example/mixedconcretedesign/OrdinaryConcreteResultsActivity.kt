package com.example.mixedconcretedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class OrdinaryConcreteResultsActivity : AppCompatActivity() {
    lateinit var cementVal : AppCompatTextView
    lateinit var ggbsVal : AppCompatTextView
    lateinit var flyashVal : AppCompatTextView
    lateinit var metakoalineVal : AppCompatTextView
    lateinit var ricehuskVal : AppCompatTextView
    lateinit var silicafumeVal : AppCompatTextView
    lateinit var waterVal : AppCompatTextView
    lateinit var fineaggVal : AppCompatTextView
    lateinit var coarseaggVal : AppCompatTextView
    lateinit var chemadVal : AppCompatTextView
    lateinit var densityVal : AppCompatTextView
    lateinit var volumetricBtn : AppCompatButton
    lateinit var volumeET : AppCompatEditText


    fun inittv(){
        chemadVal =  findViewById(R.id.chemadVal)
        coarseaggVal =  findViewById(R.id.coarseaggVal)
        fineaggVal =  findViewById(R.id.fineaggVal)
        waterVal =  findViewById(R.id.waterVal)
        silicafumeVal =  findViewById(R.id.silicafumeVal)
        ricehuskVal =  findViewById(R.id.ricehuskVal)
        metakoalineVal =  findViewById(R.id.metakoalineVal)
        flyashVal =  findViewById(R.id.flyashVal)
        ggbsVal =  findViewById(R.id.ggbsVal)
        cementVal =  findViewById(R.id.cementVal)
        volumetricBtn =  findViewById(R.id.volumetricBtn)
        volumeET =  findViewById(R.id.volumeET)
stipulateProportion = intent.getSerializableExtra("sp") as StipulateProportion
graphValue = intent.getSerializableExtra("gv") as GraphValue
        settvData(graphValue, 1)
        volumetricBtn.setOnClickListener {
            if(!volumeET.text.isNullOrEmpty()) {
                val str = volumeET.text.toString().toDouble().toInt()
                settvData(graphValue,str )
            }else{
                settvData(graphValue, 1)

            }
        }
    }
    lateinit var stipulateProportion : StipulateProportion
    lateinit var graphValue: GraphValue


    fun settvData( graphval: GraphValue, multiplier : Int){
        cementVal.text = ""+graphval.cementcontent*multiplier
        waterVal.text = ""+graphval.watercontent*multiplier
        fineaggVal.text = ""+graphval.volumeoffineAggregate*multiplier
        coarseaggVal.text = ""+graphval.volumeofcoarseAggregate*multiplier

        chemadVal.text = ""+stipulateProportion.admixturevalue*multiplier
        silicafumeVal.text = ""+stipulateProportion.silica_fume_value*multiplier
        ricehuskVal.text = ""+stipulateProportion.ricehuskash_value*multiplier
        metakoalineVal.text = ""+stipulateProportion.metakaonline_value*multiplier
        flyashVal.text = ""+stipulateProportion.flyash_value*multiplier
        ggbsVal.text = ""+stipulateProportion.GGBS_value*multiplier


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordinary_concrete_results)
        inittv()
    }
}