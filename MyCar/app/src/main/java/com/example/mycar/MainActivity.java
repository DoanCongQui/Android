package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;



import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public Button Button_Std;
    public Button Button_Forecast;
    public Button Button_Reality;
    public TextView TextView_Std;
    public TextView TextView_Forecast;
    public TextView TextView_Reality;

    public LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Button
        Button_Std = findViewById(R.id.btn_Std);
        Button_Forecast = findViewById(R.id.btn_Forecast);
        Button_Reality = findViewById(R.id.btn_Reality);

        // Create TextView
        TextView_Std = findViewById(R.id.txt_Std);
        TextView_Forecast = findViewById(R.id.txt_Forecast);
        TextView_Reality = findViewById(R.id.txt_Reality);

        // Create LineChart
        lineChart = findViewById(R.id.line_chart);

        // Button Run
        Button_Std.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView_Std.setText("0.5");
            }
        });
        Button_Forecast.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView_Forecast.setText("0.6");
            }
        });
        Button_Reality.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView_Reality.setText("0.8");
            }
        });

        // Create data for roads
        List<Entry> entries1 = new ArrayList<>();
        List<Entry> entries2 = new ArrayList<>();
        List<Entry> entries3 = new ArrayList<>();


        entries1.add(new Entry(0, 20));
        entries1.add(new Entry(1, 24));
        entries1.add(new Entry(2, 10));
        entries1.add(new Entry(3, 4));
        entries1.add(new Entry(4, 34));

        entries2.add(new Entry(1, 25));
        entries2.add(new Entry(2, 17));
        entries2.add(new Entry(3, 2));
        entries2.add(new Entry(4, 3));
        entries2.add(new Entry(5, 19));

        entries3.add(new Entry(0, 3));
        entries3.add(new Entry(1, 10));
        entries3.add(new Entry(4, 1));
        entries3.add(new Entry(8, 40));
        entries3.add(new Entry(5, 21));

        // Create DataSet of the lines
        LineDataSet dataSet1 = new LineDataSet(entries1, "Std ");
        LineDataSet dataSet2 = new LineDataSet(entries2, "Forecast ");
        LineDataSet dataSet3 = new LineDataSet(entries3, "Reality ");

        // Set the color of the lines
        dataSet1.setColor(Color.BLUE);
        dataSet2.setColor(Color.GREEN);
        dataSet3.setColor(Color.RED);

        // Create LineData
        LineData lineData = new LineData(dataSet1, dataSet2, dataSet3);

        // x-axis format
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // y-axis format
        YAxis leftYAxis = lineChart.getAxisLeft();
        leftYAxis.setAxisMinimum(0); // Minimum value of the y-axis
        YAxis rightYAxis = lineChart.getAxisRight();
        rightYAxis.setEnabled(false); // Turn off the right y-axis

        // Set up data for the chart
        lineChart.setData(lineData);
        lineChart.getDescription().setEnabled(false);
    }
}

