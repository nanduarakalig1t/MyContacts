package com.example.mycontacts.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mycontacts.R;

public class DetailDisplay extends AppCompatActivity {
    private TextView tvdName;
    private TextView tvdPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildisplay);
        tvdName = findViewById(R.id.tvdName);
        tvdPhone = findViewById(R.id.tvdPhone);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");

            tvdName.setText(name);
            tvdPhone.setText(phone);
        }

    }
}