package com.polinema.smartkos.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewmodel.PenghuniViewModel;

import java.util.List;

public class TambahPenghuni extends AppCompatActivity {
    public static final String EXTRA_NAMA =
            "com.polinema.smartkos.activities.EXTRA_NAMA";
    public static final String EXTRA_NOKAMAR=
            "com.polinema.smartkos.activities.EXTRA_NOKAMAR";
    public static final String EXTRA_NOHP=
            "com.polinema.smartkos.activities.EXTRA_NOHP";
    public static final String EXTRA_NOKTP =
            "com.polinema.smartkos.activities.EXTRA_NOKTP";
    public static final String EXTRA_TGLBAYAR =
            "com.polinema.smartkos.activities.EXTRA_TGLBAYAR";

    private EditText editNama, editNoKamar, editNoHp, editNoKtp, editTglBayar;
    private Button buttonSimpanPenghuni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penghuni);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

//        Spinner spinnerKamar = (Spinner) findViewById(R.id.spinnerKamar);
//        String[] kamar = new String[]{
//                "A1",
//                "A2",
//                "A3"
//        };
//        ArrayAdapter<String> spinnerKamarAdapter = new ArrayAdapter<String>(this,R.layout.spinner,kamar);
//        spinnerKamarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerKamar.setAdapter(spinnerKamarAdapter);

        editNama = findViewById(R.id.edtNama);
        editNoKamar = findViewById(R.id.edtNoKamar);
        editNoHp = findViewById(R.id.edtNoHp);
        editNoKtp = findViewById(R.id.edtNoKtp);
        editTglBayar = findViewById(R.id.edtTanggalBayar);

        buttonSimpanPenghuni = findViewById(R.id.btnSimpanPenghuni);
        buttonSimpanPenghuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePenghuni();
            }
        });
    }

    private void savePenghuni(){
        String namaPenghuni = editNama.getText().toString();
        String noKamar = editNoKamar.getText().toString();
        String noHp = editNoHp.getText().toString();
        String noKtp = editNoKtp.getText().toString();
        String tglBayar = editTglBayar.getText().toString();

        if (namaPenghuni.trim().isEmpty() || noKamar.trim().isEmpty() || noHp.trim().isEmpty() || noKtp.trim().isEmpty() || tglBayar.trim().isEmpty()) {
            Toast.makeText(this, "Tolong isi semua data", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAMA, namaPenghuni);
        data.putExtra(EXTRA_NOKAMAR, noKamar);
        data.putExtra(EXTRA_NOHP, noHp);
        data.putExtra(EXTRA_NOKTP, noKtp);
        data.putExtra(EXTRA_TGLBAYAR, tglBayar);

        setResult(RESULT_OK, data);
        finish();
    }
}
