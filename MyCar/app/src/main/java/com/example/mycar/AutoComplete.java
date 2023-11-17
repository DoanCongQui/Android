package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AutoComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_txt);

        // Đọc dòng đầu tiên của file CSV để lấy danh sách cột
        List<String> headers = CSVReaderHelper.readHeadersFromCSV(getResources().openRawResource(R.raw.data));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_iterm, headers);
        autoCompleteTextView.setAdapter(adapter);

        // Xử lý sự kiện khi người dùng nhấn vào một phần tử trong danh sách
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Chuyển đến ChartActivity và truyền số cột được chọn
                Intent intent = new Intent(AutoComplete.this, ChartActivity.class);
                intent.putExtra("selectedColumn", position);
                startActivity(intent);
            }
        });
    }
}

