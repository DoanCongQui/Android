package com.example.mycar;

import android.util.Log;

import com.github.mikephil.charting.data.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderHelper {

    public static List<String> readHeadersFromCSV(InputStream inputStream) {
        List<String> headers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            if (line != null) {
                //Tach dong dau tien cua cot
                headers = Arrays.asList(line.split(","));
            }

            reader.close();
        } catch (IOException e) {
            Log.e("CSVReaderHelper", "Error reading CSV file: " + e.getMessage());
        }

        return headers;
    }

    public static List<Entry> readDataFromCSV(InputStream inputStream, int columnIndex) {
        List<Entry> entries = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                if (columnIndex < tokens.length) {
                    // Chắc chắn rằng columnIndex không vượt quá kích thước của mảng tokens
                    try {
                        float yValue = Float.parseFloat(tokens[columnIndex]);
                        entries.add(new Entry(entries.size(), yValue));
                    } catch (NumberFormatException e) {
                        Log.e("CSVReaderHelper", "Error parsing float from CSV: " + e.getMessage());
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            Log.e("CSVReaderHelper", "Error reading CSV file: " + e.getMessage());
        }

        return entries;
    }
}
