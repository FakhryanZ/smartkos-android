package com.polinema.smartkos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.polinema.smartkos.R;

import java.util.Date;

import static com.polinema.smartkos.activities.PenghuniActivity.EXTRA_NAMA;
import static com.polinema.smartkos.activities.PenghuniActivity.EXTRA_NOHP;
import static com.polinema.smartkos.activities.PenghuniActivity.EXTRA_NOKAMAR;
import static com.polinema.smartkos.activities.PenghuniActivity.EXTRA_NOKTP;

public class DetailPenghuni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penghuni);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        Intent getDetail = getIntent();
        String namaPenghuni = getDetail.getStringExtra(EXTRA_NAMA);
        String noHp = getDetail.getStringExtra(EXTRA_NOHP);
        String noKtp = getDetail.getStringExtra(EXTRA_NOKTP);
        String noKamar = getDetail.getStringExtra(EXTRA_NOKAMAR);


        TextView textKamar = findViewById(R.id.txtKamar);
        TextView textPenghuni = findViewById(R.id.txtNama);
        TextView textNIK = findViewById(R.id.txtNIK);
        TextView textHp = findViewById(R.id.txtTelp);

        textKamar.setText(noKamar);
        textPenghuni.setText(namaPenghuni);
        textNIK.setText(noKtp);
        textHp.setText(noHp);
    }
}
