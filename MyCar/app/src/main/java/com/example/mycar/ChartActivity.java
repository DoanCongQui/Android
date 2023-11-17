package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_chart);

        LineChart lineChart = findViewById(R.id.lineChart);

        // Lấy số cột được chọn từ Intent
        Intent intent = getIntent();
        int selectedColumn = intent.getIntExtra("selectedColumn", -1);

        // Đọc dữ liệu từ file CSV và thêm vào biểu đồ
        List<Entry> entries = CSVReaderHelper.readDataFromCSV(getResources().openRawResource(R.raw.data), selectedColumn);

        LineDataSet dataSet = new LineDataSet(entries, "Data");
        dataSet.setColor(getResources().getColor(R.color.dark_blue));

        lineChart.setData(new LineData(dataSet));

        // Cấu hình trục x
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new XAxisValueFormatter());

        // Cấu hình trục y
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setValueFormatter(new YAxisValueFormatter());

        lineChart.getAxisRight().setEnabled(false);

        lineChart.invalidate();
    }

    private static class XAxisValueFormatter extends ValueFormatter {
        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            return String.valueOf((int) value);
        }
    }

    private static class YAxisValueFormatter extends ValueFormatter {
        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            return String.valueOf(value);
        }
    }
}
