package com.polinema.smartkos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.polinema.smartkos.R;

public class TambahPengeluaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        Spinner spinnerPengeluaran = (Spinner) findViewById(R.id.spinnerPengeluaran);
        String[] pengeluaran = new String[]{
                "Listrik & Air",
                "Internet (WiFi)",
                "Pelayanan Kebersihan"
        };
        ArrayAdapter<String> spinnerPengeluaranAdapter = new ArrayAdapter<String>(this,R.layout.spinner,pengeluaran);
        spinnerPengeluaranAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPengeluaran.setAdapter(spinnerPengeluaranAdapter);
    }
}
