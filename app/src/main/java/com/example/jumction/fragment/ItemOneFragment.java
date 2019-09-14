package com.example.jumction.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jumction.R;
import com.example.jumction.RestClient;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import cz.msebera.android.httpclient.Header;

public class ItemOneFragment extends Fragment {
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
    ArrayList<String> labels;
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_one, container, false);


         labels = new ArrayList<String>();

        int [] colors = new int[]{R.color.colorBlueLight , R.color.colorBlueDARK,R.color.colorBar3,R.color.colorBar6};
        labels.add("Sat");
        labels.add("Sun");
        labels.add("Mon");
        labels.add("Tues");
        labels.add("Wed");
        labels.add("Thurs");
        labels.add("Fri");
        barChart = view.findViewById(R.id.barchart);
        getBarChartEntries();
        barDataSet = new BarDataSet(barEntries,"");
        barData = new BarData(barDataSet);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.setData(barData);
        barDataSet.setColors(colors, getContext());
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);




        pieChart = view.findViewById(R.id.Piechart);
        getPieChartEntries();
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setColors(colors, getContext());
        pieDataSet.setSliceSpace(5f);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setUsePercentValues(true);
        // pieData.setValueFormatter(new PercentFormatter());


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        client.get("http://10.85.92.91/Help/Api/H2U_numberOfPersons_IDNumber", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        return view;

    }
    private void getBarChartEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, 0));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(6f, 1));
        barEntries.add(new BarEntry(5f, 3));
        barEntries.add(new BarEntry(7f, 4));
        barEntries.add(new BarEntry(3f, 3));
        barEntries.add(new BarEntry(1f, 3));
    }
    private void getPieChartEntries() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Week 1"));
        pieEntries.add(new PieEntry(4f, "Week 2"));
        pieEntries.add(new PieEntry(6f, "Week 3"));
        pieEntries.add(new PieEntry(8f, "Week 4"));

    }




}
