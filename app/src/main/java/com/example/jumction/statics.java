package com.example.jumction;

import android.graphics.Color;
import android.os.Bundle;

import com.example.jumction.mdel.BillRecord;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class statics extends AppCompatActivity {
    BarChart barChart;
    private DecimalFormat mFormat;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;
    ArrayList PieEntryLabels;
    ArrayList<BillRecord>arrayList;
    ArrayList<BillRecord>arrayListWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statics);

        BillRecord billRecord = new BillRecord(1,500,9);

       arrayList = new ArrayList<BillRecord>();

        for(int i = 0 ; i<31 ;i++){
            arrayList.add(new BillRecord(i,billRecord.getAmount()/30,billRecord.getMonth() ));
        }
        for(int i = 0 ; i<4 ;i++){
            arrayListWeek.add(new BillRecord(i,billRecord.getAmount()/4,billRecord.getMonth() ));
        }

        ArrayList<String> labels = new ArrayList<String>();

        int [] colors = new int[]{R.color.colorBlueLight , R.color.colorBlueDARK,R.color.colorBar3,R.color.colorBar6};
        labels.add("Sat");
        labels.add("Sun");
        labels.add("Mon");
        labels.add("Tues");
        labels.add("Wed");
        labels.add("Thurs");
        labels.add("Fri");
        barChart = findViewById(R.id.barchart);
        getBarChartEntries();
        barDataSet = new BarDataSet(barEntries,"");
        barData = new BarData(barDataSet);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.setData(barData);
        barDataSet.setColors(colors, this);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);




        pieChart = findViewById(R.id.Piechart);
        getPieChartEntries();
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setColors(colors, this);
        pieDataSet.setSliceSpace(5f);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setUsePercentValues(true);
       // pieData.setValueFormatter(new PercentFormatter());

    }
    private void getBarChartEntries() {
        barEntries = new ArrayList<>();
        for (int i =0 ; i<7 ; i++){
            barEntries.add(new BarEntry(2f, (float) arrayList.get(i).getAmount()));
        }


    }
    private void getPieChartEntries() {
        pieEntries = new ArrayList<>();
        for (int i =0 ; i<4 ; i++){
            pieEntries.add(new PieEntry((float) arrayListWeek.get(i).getAmount(), "Week "+i+1));

        }


    }





    }




