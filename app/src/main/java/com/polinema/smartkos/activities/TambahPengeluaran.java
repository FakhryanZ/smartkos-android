package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.polinema.smartkos.R;

import java.text.DateFormat;
import java.util.Calendar;

public class TambahPengeluaran extends AppCompatActivity {
    public static final String EXTRA_JENIS = "com.polinema.smartkos.activities.EXTRA_JENIS";
    public static final String EXTRA_JUMLAH = "com.polinema.smartkos.activities.EXTRA_JUMLAH";
    public static final String EXTRA_TANGGAL = "com.polinema.smartkos.activities.EXTRA_TANGGAL";
    private EditText editTextJumlah;
    private Spinner spinnerPengeluaran;
    private String currentDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        spinnerPengeluaran = (Spinner) findViewById(R.id.spinnerPengeluaran);
        String[] pengeluaran = new String[]{
                "Listrik & Air",
                "Internet (WiFi)",
                "Pelayanan Kebersihan"
        };
        ArrayAdapter<String> spinnerPengeluaranAdapter = new ArrayAdapter<String>(this,R.layout.spinner,pengeluaran);
        spinnerPengeluaranAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPengeluaran.setAdapter(spinnerPengeluaranAdapter);

        editTextJumlah = findViewById(R.id.edit_text_jumlah);

    }

    public void simpanButtonClicked(View view) {
        String jenis = spinnerPengeluaran.getSelectedItem().toString();
        int jumlah = Integer.parseInt(editTextJumlah.getText().toString());
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        Intent data = new Intent();
        data.putExtra(EXTRA_JENIS,jenis);
        data.putExtra(EXTRA_JUMLAH,jumlah);
        data.putExtra(EXTRA_TANGGAL,currentDate);

        setResult(RESULT_OK, data);
        finish();
    }
}
