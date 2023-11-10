package com.dq.obd.myreader;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button displayButton;
    private Button displayButton2;
    private Button displayButton3;
    private TextView displayTestView;
    private TextView displayTestView2;
    private TextView displayTestView3;

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayButton = findViewById(R.id.button);
        displayTestView = findViewById(R.id.textView5);
        displayButton2 = findViewById(R.id.button2);
        displayTestView2 = findViewById(R.id.textView6);
        displayButton3 = findViewById(R.id.button3);
        displayTestView3 = findViewById(R.id.textView7);

        lineChart = findViewById(R.id.line_chart);

        LineDataSet lineDataSet = new LineDataSet(dataValues1(), "Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();


        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTestView.setText("Hello");
            }
        });

        displayButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTestView2.setText("Hello");
            }
        });

        displayButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTestView3.setText("Hello");
            }
        });
    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0, 20));
        dataVals.add(new Entry(1, 24));
        dataVals.add(new Entry(2, 2));
        dataVals.add(new Entry(3, 10));
        dataVals.add(new Entry(4, 28));

        return dataVals;
    }

}