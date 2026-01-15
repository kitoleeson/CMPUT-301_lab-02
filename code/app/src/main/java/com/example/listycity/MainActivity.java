package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityList = findViewById(R.id.city_list);
        cityList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, R.id.content_view, dataList);
        cityList.setAdapter(cityAdapter);

        EditText textInput = findViewById(R.id.text_input);

        Button add_button = (Button) findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String city = textInput.getText().toString();
                cityAdapter.add(city);
                textInput.setText("");
            }
        });

        Button remove_button = (Button) findViewById(R.id.remove_button);
        remove_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int pos = cityList.getCheckedItemPosition();
                if (pos == ListView.INVALID_POSITION) return;
                dataList.remove(pos);
                cityAdapter.notifyDataSetChanged();
                cityList.clearChoices();
            }
        });
    }

}