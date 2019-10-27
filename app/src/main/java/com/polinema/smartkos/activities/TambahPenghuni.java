package com.polinema.smartkos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.polinema.smartkos.R;

public class TambahPenghuni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penghuni);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        Spinner spinnerKamar = (Spinner) findViewById(R.id.spinnerKamar);
        String[] kamar = new String[]{
                "A1",
                "A2",
                "A3"
        };
        ArrayAdapter<String> spinnerKamarAdapter = new ArrayAdapter<String>(this,R.layout.spinner,kamar);
        spinnerKamarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKamar.setAdapter(spinnerKamarAdapter);
    }
}
