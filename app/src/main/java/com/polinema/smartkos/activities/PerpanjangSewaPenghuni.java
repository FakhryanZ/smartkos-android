package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewModel.PenghuniViewModel;

import java.util.Calendar;
import java.util.Date;

public class PerpanjangSewaPenghuni extends AppCompatActivity {
    public static final String EXTRA_JUMLAHBULAN =
            "com.polinema.smartkos.activities.EXTRA_CURPENGHUNI";
    EditText jumlahBulan;
    Button buttonSimpanJumlahBulan;
    private PenghuniViewModel penghuniViewModel;
    private Penghuni currentPenghuni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perpanjang_sewa_penghuni);

        Intent intent = getIntent();
        currentPenghuni = intent.getParcelableExtra("CurrentPenghuni");
        String name = currentPenghuni.getNama();

        TextView nama = findViewById(R.id.tvNamaUneditable);
        nama.setText(name);

        jumlahBulan = findViewById(R.id.jumlah_bulan);

        penghuniViewModel = ViewModelProviders.of(this).get(PenghuniViewModel.class);

        buttonSimpanJumlahBulan = findViewById(R.id.btnSimpanJumlahBulan);
        buttonSimpanJumlahBulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveJumlahBulan();
            }
        });
    }

    public void saveJumlahBulan() {
        int jumlahBln = Integer.parseInt(jumlahBulan.getText().toString());

        Intent intent = getIntent();
        currentPenghuni = intent.getParcelableExtra("CurrentPenghuni");
        String nama = currentPenghuni.getNama();
        String noHp = currentPenghuni.getNoHp();
        String noKtp = currentPenghuni.getNoKtp();
        Date tglBayar = currentPenghuni.getTglMasuk();
        String noKamar = currentPenghuni.getIdKamar();
        Date tglHabis = currentPenghuni.getTglHabis();
        int id = currentPenghuni.getIdPenghuni();

        Calendar cal = Calendar.getInstance();
        cal.setTime(tglHabis);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+jumlahBln));
        Date tglHabisUpdate = cal.getTime();

        Toast.makeText(this, tglHabis.toString(), Toast.LENGTH_SHORT).show();
//        currentPenghuni.setTglHabis(tglHabisUpdate);
        Penghuni penghuni = new Penghuni(nama, noHp, noKtp, tglBayar, noKamar, tglHabisUpdate);
        penghuni.setIdPenghuni(id);
//        penghuni.setTglHabis(tglHabisUpdate);
        penghuniViewModel.update(penghuni);
//        penghuniViewModel.updateTglHabis(tglHabisUpdate,id);
        System.out.println(tglHabis);
//        Intent data = new Intent();
//        data.putExtra(EXTRA_JUMLAHBULAN, jumlahBln);
//
//        setResult(RESULT_OK, data);
//        finish();
    }
}
