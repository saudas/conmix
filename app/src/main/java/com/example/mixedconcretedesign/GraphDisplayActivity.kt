package com.example.mixedconcretedesign

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import java.io.Serializable
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList

class GraphDisplayActivity : AppCompatActivity() {

    private val MAX_X_VALUE = 13
    private val GROUPS = 2
    private val GROUP_1_LABEL = "Orders"
    private val GROUP_2_LABEL = ""
    private val BAR_SPACE = 0.1f
    private val BAR_WIDTH = 0.8f
    private var pieChart: PieChart? = null
    protected var tfRegular: Typeface? = null
    protected var tfLight: Typeface? = null
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
    lateinit var wcratioVal : AppCompatTextView
    lateinit var densityVal : AppCompatTextView
    lateinit var volumetricBtn : AppCompatButton

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
        wcratioVal =  findViewById(R.id.wcratioVal)
        densityVal =  findViewById(R.id.densityVal)
        volumetricBtn =  findViewById(R.id.volumetricBtn)
        volumetricBtn.setOnClickListener {
            val intent = Intent(this,OrdinaryConcreteResultsActivity::class.java)
            intent.putExtra("sp",stipulateProportion)
            intent.putExtra("gv",graphValue)
            startActivity(intent)
        }
    }

    private val calendar: Calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)

    private val statValues: ArrayList<Float> = ArrayList()
    fun settvData( graphval: GraphValue){
        cementVal.text = ""+graphval.cementcontent
        waterVal.text = ""+graphval.watercontent
        fineaggVal.text = ""+graphval.volumeoffineAggregate
        coarseaggVal.text = ""+graphval.volumeofcoarseAggregate

        chemadVal.text = ""+stipulateProportion.admixturevalue
        silicafumeVal.text = ""+stipulateProportion.silica_fume_value
        ricehuskVal.text = ""+stipulateProportion.ricehuskash_value
        metakoalineVal.text = ""+stipulateProportion.metakaonline_value
        flyashVal.text = ""+stipulateProportion.flyash_value
        ggbsVal.text = ""+stipulateProportion.GGBS_value
        wcratioVal.text = ""+graphval.watercontentratio


    }



    lateinit var stipulateProportion : StipulateProportion
    lateinit var graphValue: GraphValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_display)
        stipulateProportion = intent.getSerializableExtra("sp") as StipulateProportion
        pieChart = findViewById(R.id.pieChart)
        inittv()
        preparePieData()
        pieChartDataFormulation()

    }
    fun calculateVolumeOfAggregate(graphVal : GraphValue,volCoarseAgg : Float):Float{
        //private static final DecimalFormat decfor = new DecimalFormat("0.00");
       // val df = DecimalFormat("0.0000")
        val vocon= 1f
        val voa =0.01f
        val vocem = ((graphVal.cementcontent/2.88f)*1f/1000f).toFloat()

        val voWat =((graphVal.watercontent/1)*1f/1000f).toFloat()
        val voAllinAgg = (vocon-voa)-(vocem+voWat)
        val voCA = voAllinAgg*(volCoarseAgg)*stipulateProportion.courseAggregate.toFloat()*1000
        return voCA
    }
    fun calculateVolumeOfFineAggregate(graphVal : GraphValue,volCoarseAgg : Float):Float{
        val vocon= 1f
        val voa =0.01f
       // val df = DecimalFormat("0.0000")
        val vocem = ((graphVal.cementcontent/2.88f)*1f/1000f).toFloat()
        val voWat = ((graphVal.watercontent/1)*1f/1000f).toFloat()
        val voAllinAgg = (vocon-voa)-(vocem+voWat)
        val voCA = voAllinAgg*(volCoarseAgg)*stipulateProportion.fineAggregate.toFloat()*1000
        return voCA
    }
    fun pieChartDataFormulation(){
        if(stipulateProportion!= null){
            if(stipulateProportion.gradeOfConcrete == GradeOfConcrete.M10){
                val graphVal = GraphValue()
                graphVal.watercontent = (186 + (3f/100f)*(186)).toFloat()
                graphVal.watercontentratio = 0.60f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()

                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.64-0.02).toFloat())
                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.62).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (10+1.65*3.5).toFloat()
                setPieChartData(graphVal)

            }else if(stipulateProportion.gradeOfConcrete == GradeOfConcrete.M15){
                val graphVal = GraphValue()
                graphVal.watercontent = (186 + (3f/100)*(186)).toFloat()
                graphVal.watercontentratio = 0.55f

                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.64-0.01).toFloat())
                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.63).toFloat())
                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (15+1.65*3.5).toFloat()
                setPieChartData(graphVal)
            }else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M20){
                val graphVal = GraphValue()
                graphVal.watercontent = (191.58*0.77).toFloat()
                graphVal.watercontentratio = 0.5f

                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.64).toFloat())

                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.64).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (20+1.65*4.0).toFloat()
                setPieChartData(graphVal)
            }else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M25){
                val graphVal = GraphValue()
                graphVal.watercontent = (197.16*0.77).toFloat()
                graphVal.watercontentratio = 0.45f

                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.62+0.01).toFloat())

                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.63).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (25+1.65*4.0).toFloat()
                setPieChartData(graphVal)
            }
            else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M30){
                val graphVal = GraphValue()
                graphVal.watercontent = (202.0*0.77).toFloat()
                graphVal.watercontentratio = 0.45f

                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.6546*0.9).toFloat())
                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.589).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (30+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            } else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M35){
                val graphVal = GraphValue()

                graphVal.watercontent = (202.0*0.77).toFloat()
                graphVal.watercontentratio = 0.4f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.6546*0.9).toFloat())

                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.589).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (35+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }
            else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M40){
                val graphVal = GraphValue()
                graphVal.watercontent = (172.0*0.77).toFloat()
                graphVal.watercontentratio = 0.4f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                //graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.6615*0.59).toFloat())
                graphVal.volumeofcoarseAggregate =  1069f
                //graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.59).toFloat())
                graphVal.volumeoffineAggregate =  719f

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (40+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M45){
                val graphVal = GraphValue()
                graphVal.watercontent = (155f).toFloat()
                graphVal.watercontentratio = 0.41f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                //graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.5904).toFloat())
                graphVal.volumeofcoarseAggregate = 1032f
                graphVal.volumeoffineAggregate = 692.58f
                //graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.5904).toFloat())
                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (45+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M50){
                val graphVal = GraphValue()
                graphVal.watercontent = (147.6).toFloat()
                graphVal.watercontentratio = 0.348f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
               // graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.55).toFloat())
                graphVal.volumeofcoarseAggregate = 706f
                graphVal.volumeoffineAggregate = 621f
                //graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.55).toFloat())
                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (50+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M55){
                val graphVal = GraphValue()
                graphVal.watercontent = (137).toFloat()
                graphVal.watercontentratio = 0.349f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
               // graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.5904).toFloat())
                graphVal.volumeofcoarseAggregate = 726f
                graphVal.volumeoffineAggregate =  660f
               // graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.5904).toFloat())
                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (55+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            } else if (stipulateProportion.gradeOfConcrete == GradeOfConcrete.M60){
                val graphVal = GraphValue()
                graphVal.watercontent = (166.4).toFloat()
                graphVal.watercontentratio = 0.3199f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = 1094f
                graphVal.volumeoffineAggregate = 703f
                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (60+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }
            else{
                val graphVal = GraphValue()
                graphVal.watercontent = (201.62*0.77).toFloat()
                graphVal.watercontentratio = 0.36f
                graphVal.cementcontent = (graphVal.watercontent/graphVal.watercontentratio).toFloat()
                graphVal.volumeofcoarseAggregate = calculateVolumeOfAggregate(graphVal,(0.6546*0.9).toFloat())
                graphVal.volumeoffineAggregate = calculateVolumeOfFineAggregate(graphVal,(1-0.589).toFloat())

                graphVal.aircontent = (1.0).toFloat()
                graphVal.targetCompressiveStrength = (40+1.65*5.0).toFloat()
                setPieChartData(graphVal)
            }
        }


    }

    private fun preparePieData() {
//pie chart
        pieChart!!.setUsePercentValues(false)
        pieChart!!.description.isEnabled = false
        pieChart!!.setExtraOffsets(15F, 10F, 15F, 15F)

        pieChart!!.dragDecelerationFrictionCoef = 0.95f

        pieChart!!.setCenterTextTypeface(tfLight)
       // pieChart!!.centerText = generateCenterSpannableText()

        pieChart!!.isDrawHoleEnabled = true
        pieChart!!.setHoleColor(Color.WHITE)

        pieChart!!.setTransparentCircleColor(Color.WHITE)
        pieChart!!.setTransparentCircleAlpha(110)

        pieChart!!.holeRadius = 20f
        pieChart!!.transparentCircleRadius = 30f

        pieChart!!.setDrawCenterText(true)

        pieChart!!.rotationAngle = 0.toFloat()
        // enable rotation of the chart by touch
        pieChart!!.isRotationEnabled = true
        pieChart!!.isHighlightPerTapEnabled = true


//        pieChart!!.animateY(1400, Easing.EaseInOutQuad)
        // pieChart.spin(2000, 0, 360);

        pieChart!!.spin(2000, 0F, 360F, Easing.EaseInOutQuad)
        val l = pieChart!!.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.xEntrySpace = 0f
        l.yEntrySpace = 0f
        l.yOffset = 0f

        // entry label styling
        pieChart!!.setEntryLabelColor(Color.WHITE)
        pieChart!!.setEntryLabelTypeface(tfRegular)
        pieChart!!.setEntryLabelTextSize(10f)
    }
   fun  setPieChartData(value : GraphValue) {
        val entries: ArrayList<PieEntry> = ArrayList()
       graphValue = value

        entries.add(PieEntry(value.watercontent, "Water Content"))
        entries.add(PieEntry(value.cementcontent, "Cement Content"))
        entries.add(PieEntry(value.volumeofcoarseAggregate, "Course Aggregate in m3"))
        entries.add(PieEntry(value.volumeoffineAggregate, "Fine Aggregate in m3"))
        entries.add(PieEntry(value.aircontent, "Air Content"))
        entries.add(PieEntry(value.targetCompressiveStrength, "Target Compressive"))

        //you can test above by adding random dummy data to the pie chart or passing the data from the backend.

        //entries.add(PieEntry(random.nextInt(100).toFloat(), "Orders"))
        //entries.add(PieEntry(random.nextInt(100).toFloat(), "Inventory"))

        val dataSet = PieDataSet(entries, "")
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 1f
        dataSet.iconsOffset = MPPointF(0F, 40F)
        dataSet.selectionShift = 1f

        // add colors
        val colors: ArrayList<Int> = ArrayList()

        colors.add(ColorTemplate.rgb("#F1C40F"))
        colors.add(ColorTemplate.rgb("#2ECC71"))
        colors.add(ColorTemplate.rgb("#943126"))
        colors.add(ColorTemplate.rgb("#6495ED"))
        colors.add(ColorTemplate.rgb("#CCCCFF"))
        colors.add(ColorTemplate.rgb("#DE3163"))
        colors.add(ColorTemplate.rgb("#6495ED"))

       colors.add(ColorTemplate.getHoloBlue())
        dataSet.colors = colors
        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        data.setValueTypeface(tfLight)
        pieChart!!.setData(data)
       //pieChart!!.getData().setDrawValues(false)
       pieChart!!.setDrawSliceText(false)

        // undo all highlights
        pieChart!!.highlightValues(null)
        pieChart!!.invalidate()
       settvData(graphval = value)
    }

}
class GraphValue: Serializable{
    var watercontent = 0.0f
    var watercontentratio = 0.0f
    var cementcontent = 0.0f
    var volumeofcoarseAggregate = 0.0f
    var volumeoffineAggregate = 0.0f
    var aircontent = 0.0f
    var targetCompressiveStrength = 0.0f
}