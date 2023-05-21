    package com.example.mixedconcretedesign

    import android.content.Intent
    import android.graphics.Color
    import android.os.Bundle
    import android.os.Parcelable
    import android.util.Log
    import android.view.View
    import android.widget.AdapterView
    import android.widget.ArrayAdapter
    import android.widget.Spinner
    import android.widget.ToggleButton
    import androidx.appcompat.app.AppCompatActivity
    import androidx.appcompat.widget.AppCompatButton
    import androidx.appcompat.widget.AppCompatEditText
    import androidx.appcompat.widget.AppCompatTextView
    import java.io.Serializable
    import java.text.DecimalFormat


    class OrdinaryConcreteActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener  {
        lateinit var expoSpinner : Spinner
        lateinit var typeConSpinner : Spinner
        lateinit var gradepinner : Spinner
        lateinit var typecementSpinner : Spinner
        lateinit var siteSpinner : Spinner
        lateinit var methodPlaSpinner : Spinner
        lateinit var workabilitySpinner : Spinner
        lateinit var charesteristicStrengthSpinner : AppCompatTextView
        lateinit var maxsizeAggSpinner : Spinner
       // lateinit var addmixtureSpinner : Spinner
        lateinit var sizeAggregateSpinner : Spinner
        lateinit var typeAggregateSpinner : Spinner
        lateinit var zoneoffineaggrSpinner : Spinner
        lateinit var aggregateConditionSpinner : Spinner
        lateinit var autowatertb : ToggleButton
        lateinit var calculateBt : AppCompatButton
        lateinit var autowaterET : AppCompatEditText
        lateinit var waterreducingET : AppCompatEditText
        lateinit var cementetios_sg_ET : AppCompatEditText
        lateinit var water_reduced_due_sg_ET : AppCompatEditText



        //lateinit var admixtureValueET : AppCompatEditText
        lateinit var chemicalmixture_sg_ET : AppCompatEditText
        lateinit var cement_sg_ET : AppCompatEditText
        lateinit var coarse_agg_sg_ET : AppCompatEditText
        lateinit var fine_agg_sg_ET : AppCompatEditText
        lateinit var flyash_sg_ET : AppCompatEditText
        lateinit var ggbg_sg_ET : AppCompatEditText
        lateinit var silica_sg_ET : AppCompatEditText
        lateinit var metakaoline_sg_ET : AppCompatEditText
        lateinit var maximaplast_sg_ET : AppCompatEditText
        lateinit var rice_ash_sg_ET : AppCompatEditText
        lateinit var wastage_sg_ET : AppCompatEditText

        lateinit var flyashET : AppCompatEditText
        lateinit var GGBS_ET : AppCompatEditText
        lateinit var silica_fumeET : AppCompatEditText
        lateinit var metakaonlineET : AppCompatEditText
        lateinit var maximaplastET : AppCompatEditText
        lateinit var ricehuskashET : AppCompatEditText
       // lateinit var cementitiousET : AppCompatEditText
      //  lateinit var waterReducingadmixtureET : AppCompatEditText


fun setET(){
//    waterReducingadmixtureET =  findViewById(R.id.waterReducingadmixtureET)
//    cementitiousET =  findViewById(R.id.cementitiousET)
    ricehuskashET =  findViewById(R.id.ricehuskashET)
    maximaplastET =  findViewById(R.id.maximaplastET)
    metakaonlineET =  findViewById(R.id.metakaonlineET)
    silica_fumeET =  findViewById(R.id.silica_fumeET)
    GGBS_ET =  findViewById(R.id.GGBS_ET)
    flyashET =  findViewById(R.id.flyashET)



    wastage_sg_ET =  findViewById(R.id.wastage_sg_ET)
    rice_ash_sg_ET =  findViewById(R.id.rice_ash_sg_ET)
    maximaplast_sg_ET =  findViewById(R.id.maximaplast_sg_ET)
    metakaoline_sg_ET =  findViewById(R.id.metakaoline_sg_ET)
    silica_sg_ET =  findViewById(R.id.silica_sg_ET)
    ggbg_sg_ET =  findViewById(R.id.ggbg_sg_ET)
    flyash_sg_ET =  findViewById(R.id.flyash_sg_ET)
    fine_agg_sg_ET =  findViewById(R.id.fine_agg_sg_ET)
    coarse_agg_sg_ET =  findViewById(R.id.coarse_agg_sg_ET)
    cement_sg_ET =  findViewById(R.id.cement_sg_ET)
    chemicalmixture_sg_ET =  findViewById(R.id.chemicalmixture_sg_ET)
   // admixtureValueET =  findViewById(R.id.admixtureValueET)
    water_reduced_due_sg_ET =  findViewById(R.id.water_reduced_due_sg_ET)
    cementetios_sg_ET =  findViewById(R.id.cementetios_sg_ET)
    waterreducingET =  findViewById(R.id.waterreducingET)

}

        lateinit var stipulateProportion : StipulateProportion
        var expoSpinnerValue = arrayOf(
            "Mild", "Moderate",
            "Severe", "Very Severe",
            "Extreme"
        )
        var typeConSpinnerValue = arrayOf(
            "Plain Concrete", "Reinforced Concrete"
        )
        var gradepinnerValue = arrayOf(
            "M10", "M15", "M20","M25","M30","M35","M40","M45","M50","M55","M60"
        )
        var typeCemSpinnerValue = arrayOf(
            "PPC", "OPC43"
        )
        var charectorComprepinnerValue = arrayOf(
            "Good", "Fair"
        )
        var siteControlpinnerValue = arrayOf(
            "Good", "Fair"
        )
        var methodplacinginnerValue = arrayOf(
            "No Pumping", "Pumping"
        )
        var maximumNominalSizeSpinnerValue = arrayOf(
            "10",

            "20",


            "30",

            "40")
        var addmixture = arrayOf(
            "Flyash(%)",
            "GGBS(%)",
            "Silica Fume(%)",
            "Metakaoline(%)",
            "Maxima Plast 300(%)",
            "Rice Husk Ash(%)"
        )
        var aggregateConditionValue = arrayOf(
            "SSD",
            "Dry or Wet"

        )
        var zoneValue = arrayOf(
            "Zone 1",
            "Zone 2",
            "Zone 3",
            "Zone 4"

        )

        var typeAggregateValue = arrayOf(
            "Crushed Angular",
            "Sub Angular",
            "Gravel and Crused",
            "Remould gravel"

        )
        var sizeAggregateValue = arrayOf(
            "10",
            "20",
            "40"

        )

        var workablitySpinnerValue = arrayOf(
            "10",
          "15",
                  "20",
    "25",

            "30",
     "35",
     "40",
            "45",
        "50",
                    "55",
     "60",
      "65",
        "70",
       "75",
         "80",
          "85",
         "90",
         "95",
       "100",
            "105",
            "110",
            "115",
            "120",
            "125",
            "130",
            "135",
           "140",
            "145",
            "150",
            "155",
            "160",
            "165",
            "170",
            "175",
            "180",
            "185",
            "190",
            "195",
            "200",
        )

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ordinary_concrete)
            stipulateProportion = StipulateProportion()
            setET()
            initdata()
        }
        fun initdata() {
            autowaterET = findViewById(R.id.autowaterET)
            calculateBt = findViewById(R.id.calculateBt)

            expoSpinner = findViewById(R.id.expoSpinner)
            expoSpinner.onItemSelectedListener = this
            val ad: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, expoSpinnerValue)
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            expoSpinner.setAdapter(ad)


            typeConSpinner = findViewById(R.id.typeConSpinner)
            typeConSpinner.onItemSelectedListener = this
            val type_ad: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, typeConSpinnerValue)
            type_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typeConSpinner.setAdapter(type_ad)



            gradepinner = findViewById(R.id.gradepinner)
            gradepinner.onItemSelectedListener = this
            val ordinary_ad: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, gradepinnerValue)
            ordinary_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            gradepinner.setAdapter(ordinary_ad)



            typecementSpinner = findViewById(R.id.typecementSpinner)
            typecementSpinner.onItemSelectedListener = this
            val type_cement_ad: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, typeCemSpinnerValue)
            type_cement_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typecementSpinner.setAdapter(type_cement_ad)

            workabilitySpinner = findViewById(R.id.workabilitySpinner)
            workabilitySpinner.onItemSelectedListener = this
            val wprkablity_ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                workablitySpinnerValue
            )
            wprkablity_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            workabilitySpinner.setAdapter(wprkablity_ad)



            methodPlaSpinner = findViewById(R.id.methodPlaSpinner)
            methodPlaSpinner.onItemSelectedListener = this
            val method_plan__ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                methodplacinginnerValue
            )
            method_plan__ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            methodPlaSpinner.setAdapter(method_plan__ad)




            siteSpinner = findViewById(R.id.siteSpinner)
            siteSpinner.onItemSelectedListener = this
            val site_ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                siteControlpinnerValue
            )
            site_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            siteSpinner.setAdapter(site_ad)

            charesteristicStrengthSpinner = findViewById(R.id.charesteristicStrengthSpinner)



            maxsizeAggSpinner = findViewById(R.id.maxsizeAggSpinner)
            maxsizeAggSpinner.onItemSelectedListener = this
            val maxAD: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                maximumNominalSizeSpinnerValue
            )
            maxAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            maxsizeAggSpinner.setAdapter(maxAD)

//            addmixtureSpinner = findViewById(R.id.addmixtureSpinner)
//            addmixtureSpinner.onItemSelectedListener = this
            val addmixAD: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, addmixture)
            addmixAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            addmixtureSpinner.setAdapter(addmixAD)


            aggregateConditionSpinner = findViewById(R.id.aggregateConditionSpinner)
            aggregateConditionSpinner.onItemSelectedListener = this
            val aggregateConmixAD: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                aggregateConditionValue
            )
            aggregateConmixAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            aggregateConditionSpinner.setAdapter(aggregateConmixAD)

            zoneoffineaggrSpinner = findViewById(R.id.zoneoffineaggrSpinner)
            zoneoffineaggrSpinner.onItemSelectedListener = this
            val zoneAD: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, zoneValue)
            zoneAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            zoneoffineaggrSpinner.setAdapter(zoneAD)

            typeAggregateSpinner = findViewById(R.id.typeAggregateSpinner)
            typeAggregateSpinner.onItemSelectedListener = this
            val typeAggregateAD: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, typeAggregateValue)
            typeAggregateAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typeAggregateSpinner.setAdapter(typeAggregateAD)

            sizeAggregateSpinner = findViewById(R.id.sizeAggregateSpinner)
            sizeAggregateSpinner.onItemSelectedListener = this
            val sizeAggregateAD: ArrayAdapter<*> =
                ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, sizeAggregateValue)
            sizeAggregateAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sizeAggregateSpinner.setAdapter(sizeAggregateAD)

            autowatertb = findViewById(R.id.autowatertb)
            autowatertb.setOnCheckedChangeListener { _, ischecked ->
                autowaterET.isEnabled = !ischecked
            }
            calculateBt.setOnClickListener {
                setvalues()
                openGraphActivity()
            }
        }
        fun openGraphActivity(){
            val intent = Intent(this,GraphDisplayActivity::class.java)
            intent.putExtra("sp",stipulateProportion)
            startActivity(intent)

        }
        fun setValueForCompressiveStrenth(value : Int){
            val result = value
            charesteristicStrengthSpinner.text = ""+result+" mpa"
            stipulateProportion.charesteristicStrength = value
        }

        override fun onItemSelected(adapter: AdapterView<*>?, p1: View?, position: Int, id: Long) {
            if(adapter?.id == R.id.gradepinner){
                stipulateProportion.gradeOfConcrete = GradeOfConcrete.values().get(position)
                when (position){
                    0->
                    {
                        setValueForCompressiveStrenth(10)
                        workabilitySpinner.setSelection(13)
                        //13 is a posititon of 75 in the list
                    }
                    1->{
                        setValueForCompressiveStrenth(15)
                        expoSpinner.setSelection(1)
                        workabilitySpinner.setSelection(13)
                    }
                    2->{
                        setValueForCompressiveStrenth(20)
                        expoSpinner.setSelection(2)
                        workabilitySpinner.setSelection(13)

                    }
                    3->{
                        setValueForCompressiveStrenth(25)
                        expoSpinner.setSelection(0)
                        workabilitySpinner.setSelection(18)
                    }
                    4->{
                        setValueForCompressiveStrenth(30)
                        expoSpinner.setSelection(0)
                        workabilitySpinner.setSelection(22)
                    }
                    5->{
                        setValueForCompressiveStrenth(35)
                        expoSpinner.setSelection(1)
                        workabilitySpinner.setSelection(8)
                    }
                    6->{
                        setValueForCompressiveStrenth(40)
                        expoSpinner.setSelection(0)
                        workabilitySpinner.setSelection(22)
                    }
                    7->{
                        setValueForCompressiveStrenth(45)
                        expoSpinner.setSelection(2)
                        workabilitySpinner.setSelection(22)
                    }
                    8->{
                        setValueForCompressiveStrenth(50)
                        expoSpinner.setSelection(2)
                        workabilitySpinner.setSelection(22)
                    }
                    9->{
                        setValueForCompressiveStrenth(55)
                        expoSpinner.setSelection(1)
                        workabilitySpinner.setSelection(28)
                        methodPlaSpinner.setSelection(1)
                    }10->{
                        setValueForCompressiveStrenth(60)
                        expoSpinner.setSelection(1)
                        workabilitySpinner.setSelection(8)
                    }
                }

            }
            else if(adapter?.id == R.id.expoSpinner){
                stipulateProportion.exposurecondition = EXPOSURECONDITION.values().get(position)
            }else if(adapter?.id == R.id.workabilitySpinner){
                stipulateProportion.workablity =  WORKABLITY.values().get(position)
            } else if(adapter?.id == R.id.maxsizeAggSpinner){
                stipulateProportion.maximumnominal = MAXIMUMNOMINAL.values().get(position)
            }else if(adapter?.id == R.id.typeConSpinner){
                stipulateProportion.typeofconcrete =  TYPEOFCONCRETE.values().get(position)
            }else if (adapter?.id == R.id.typecementSpinner){
                stipulateProportion.typeofcement = TYPEOFCEMENT.values().get(position)
            }else if(adapter?.id == R.id.siteSpinner){
                stipulateProportion.sitecontrol =  SITECONTROL.values().get(position)
            }else if(adapter?.id == R.id.methodPlaSpinner){
                stipulateProportion.methodofplacing = METHODOFPLACING.values().get(position)
            }else if (adapter?.id == R.id.sizeAggregateSpinner){
                stipulateProportion.sizeofaggregate = SIZEOFAGGREGATE.values().get(position)
            }else if(adapter?.id == R.id.typeAggregateSpinner){
                stipulateProportion.typeofaggregate =  TYPEOFAGGREGATE.values().get(position)
            }else if(adapter?.id == R.id.zoneoffineaggrSpinner){
                stipulateProportion.zoneofaggre = ZONEOFAGGRE.values().get(position)
            }else if(adapter?.id == R.id.aggregateConditionSpinner){
                stipulateProportion.aggregatecondition = AGGREGATECONDITION.values().get(position)
            }
//            else if (adapter?.id == R.id.addmixtureSpinner){
//                stipulateProportion.typeofmineraladmixture = TYPEOFMINERALADMIXTURE.values().get(position)
//            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }


        fun setvalues(){
            if(!autowaterET.text.isNullOrEmpty()) {
                stipulateProportion.manualwcratio = autowaterET.text.toString().toDouble()
            }else{
                stipulateProportion.manualwcratio = 0.0
            }
            if(!waterreducingET.text.isNullOrEmpty()) {
                    stipulateProportion.waterreducedadmixture = waterreducingET.text.toString().toDouble()
                }else{
                    stipulateProportion.waterreducedadmixture = 0.0
                }
            if(!rice_ash_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.riceashhusk = rice_ash_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.riceashhusk = 0.0
                }
            if(!metakaoline_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.metakoline = metakaoline_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.metakoline = 0.0
                }
            if(!maximaplast_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.maximaplast = maximaplast_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.riceashhusk = 0.0
                }

            if(!silica_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.silicafume = silica_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.silicafume = 0.0
                }

            if(!ggbg_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.ggbg = ggbg_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.ggbg = 0.0
                }
            if(!flyash_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.flyash = flyash_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.flyash = 0.0
                }
            if(!fine_agg_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.fineAggregate = fine_agg_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.fineAggregate = 0.0
                }
            if(!coarse_agg_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.courseAggregate = coarse_agg_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.courseAggregate = 0.0
                }
            if(!cement_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.cement = cement_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.cement = 0.0
                }

            if(!chemicalmixture_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.chemicaladmixture = chemicalmixture_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.chemicaladmixture = 0.0
                }

            if(!wastage_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.wastagematarial = wastage_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.wastagematerial = 0.0
                }

//            if(!admixtureValueET.text.isNullOrEmpty()) {
//                    stipulateProportion.admixturevalue = admixtureValueET.text.toString().toDouble()
//                }else{
//                    stipulateProportion.admixturevalue = 0.0
//                }

            if(!water_reduced_due_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.waterreducingdueadmixture = water_reduced_due_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.waterreducingdueadmixture = 0.0
                }
            if(!cementetios_sg_ET.text.isNullOrEmpty()) {
                    stipulateProportion.cementious = cementetios_sg_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.cementious = 0.0
                }

            if(!flyashET.text.isNullOrEmpty()) {
                    stipulateProportion.flyash_value = flyashET.text.toString().toDouble()
                }else{
                    stipulateProportion.flyash_value = 0.0
                }
            if(!GGBS_ET.text.isNullOrEmpty()) {
                    stipulateProportion.GGBS_value = GGBS_ET.text.toString().toDouble()
                }else{
                    stipulateProportion.GGBS_value = 0.0
                }

            if(!silica_fumeET.text.isNullOrEmpty()) {
                    stipulateProportion.silica_fume_value = silica_fumeET.text.toString().toDouble()
                }else{
                    stipulateProportion.silica_fume_value = 0.0
                }

            if(!metakaonlineET.text.isNullOrEmpty()) {
                    stipulateProportion.metakaonline_value = metakaonlineET.text.toString().toDouble()
                }else{
                    stipulateProportion.metakaonline_value = 0.0
                }
            if(!maximaplastET.text.isNullOrEmpty()) {
                    stipulateProportion.maximaplast_value = maximaplastET.text.toString().toDouble()
                }else{
                    stipulateProportion.maximaplast_value = 0.0
                }
            if(!ricehuskashET.text.isNullOrEmpty()) {
                    stipulateProportion.ricehuskash_value = ricehuskashET.text.toString().toDouble()
                }else{
                    stipulateProportion.ricehuskash_value = 0.0
                }


        }
    }


    class StipulateProportion : Serializable {
         var gradeOfConcrete : GradeOfConcrete = GradeOfConcrete.M10
         var exposurecondition: EXPOSURECONDITION = EXPOSURECONDITION.MILD
         var workablity: WORKABLITY = WORKABLITY.V175
         var maximumnominal: MAXIMUMNOMINAL = MAXIMUMNOMINAL.V10
         var typeofconcrete: TYPEOFCONCRETE = TYPEOFCONCRETE.PLAINCONCRETE
         var typeofcement: TYPEOFCEMENT = TYPEOFCEMENT.PPC
         var sitecontrol: SITECONTROL = SITECONTROL.GOOD
         var methodofplacing: METHODOFPLACING = METHODOFPLACING.NOPUMPING
         var manualwcratio : Double = 0.0
         var sizeofaggregate: SIZEOFAGGREGATE = SIZEOFAGGREGATE.V10
         var typeofaggregate: TYPEOFAGGREGATE = TYPEOFAGGREGATE.CRUSHEDANGULAR
         var zoneofaggre: ZONEOFAGGRE = ZONEOFAGGRE.ZONE1
         var aggregatecondition: AGGREGATECONDITION = AGGREGATECONDITION.SSD
        var waterreducingdueadmixture = 0.0
        var charesteristicStrength = 0

        var cementious = 0.0
        var waterreducedadmixture = 0.0
        var typeofmineraladmixture: TYPEOFMINERALADMIXTURE = TYPEOFMINERALADMIXTURE.FLYASH
        var admixturevalue = 0.0
        var wastagematerial = 0.0
        var chemicaladmixture = 1.145
        var cement = 3.15
        var courseAggregate = 2.74
        var fineAggregate = 2.65
        var flyash = 2.2
        var ggbg = 3.0
        var silicafume = 2.2
        var metakoline = 2.6
        var maximaplast = 0.0
        var riceashhusk = 2.36
        var wastagematarial = 0.0
        var flyash_value = 0.0
        var GGBS_value = 0.0
        var silica_fume_value = 0.0
        var metakaonline_value = 0.0
        var maximaplast_value = 0.0
        var ricehuskash_value = 0.0
        var cementitious_value = 0.0
        var waterReducingadmixture_value = 0.0
    }