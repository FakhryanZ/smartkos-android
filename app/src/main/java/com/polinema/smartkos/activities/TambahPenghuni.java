package com.polinema.smartkos.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;

public class TambahPenghuni extends AppCompatActivity {
    private EditText nomorKamar, namaPenghuni, waktuSewa;
    Button buttonSimpan;
//    private PenghuniViewModel penghuniViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penghuni);

//        penghuniViewModel = ViewModelProviders.of(this).get(PenghuniViewModel.class);

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

    private void initiateComponent(View mView) {
//        nomorKamar = mView.findViewById(R.id.nomorKamar);
        namaPenghuni = mView.findViewById(R.id.namaPenghuni);
        waktuSewa = mView.findViewById(R.id.showWaktuSewa);
        buttonSimpan = mView.findViewById(R.id.button_simpan);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {
                String nmPenghuni = namaPenghuni.getText().toString();
                String noKamar = nomorKamar.getText().toString();

                if (Validation(nmPenghuni)) {
                    Penghuni penghuni = new Penghuni(nmPenghuni);
//                    penghuniViewModel.InsertPenghuni(penghuni);
                    DialogSave(mView, "Tersimpan!!", "Data Berhasil Disimpan. Apakah Anda Akan Memasukkan Data Lagi?");
                } else {
                    new AlertDialog.Builder(mView.getContext())
                            .setTitle("Attention!!")
                            .setMessage("Pastikan Semua Data Terisi")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).show();
                }
            }
        });
    }

    private boolean Validation(String nmPenghuni) {
        if ((nmPenghuni.trim().length() > 0)) {
            return true;
        } else return false;
    }

    private void DialogSave(View mView, String title, String message) {
        new AlertDialog.Builder(mView.getContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Tambah Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        namaPenghuni.setText("");
                    }
                })
                .show();
    }
}
