package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.kamar.Kamar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TambahPenghuni extends AppCompatActivity {
    public static final String EXTRA_NAMA =
            "com.polinema.smartkos.activities.EXTRA_NAMA";
    public static final String EXTRA_NOKAMAR =
            "com.polinema.smartkos.activities.EXTRA_NOKAMAR";
    public static final String EXTRA_NOHP =
            "com.polinema.smartkos.activities.EXTRA_NOHP";
    public static final String EXTRA_NOKTP =
            "com.polinema.smartkos.activities.EXTRA_NOKTP";
    public static final String EXTRA_TGLBAYAR =
            "com.polinema.smartkos.activities.EXTRA_TGLBAYAR";

    private EditText editNama, editNoHp, editNoKtp, editTglBayar;
    private Spinner spinnerKamar;
    private Button buttonSimpanPenghuni;
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penghuni);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        List<Kamar> kamars = new ArrayList<>();
        Kamar kamar1 = new Kamar("KA 1-1",1);
        kamars.add(kamar1);
        Kamar kamar2 = new Kamar("KA 1-2",1);
        kamars.add(kamar2);
        Kamar kamar3 = new Kamar("KA 1-3",1);
        kamars.add(kamar3);
        Kamar kamar4 = new Kamar("KA 1-4",1);
        kamars.add(kamar4);
        Kamar kamar5 = new Kamar("KA 1-5",1);
        kamars.add(kamar5);
        Kamar kamar6 = new Kamar("KA 1-6",1);
        kamars.add(kamar6);
        Kamar kamar7 = new Kamar("KA 1-7",1);
        kamars.add(kamar7);
        Kamar kamar8 = new Kamar("KA 1-8",1);
        kamars.add(kamar8);
        Kamar kamar9 = new Kamar("KA 1-9",1);
        kamars.add(kamar9);
        Kamar kamar10 = new Kamar("KA 1-10",1);
        kamars.add(kamar10);
        Kamar kamar11 = new Kamar("KA 2-1",1);
        kamars.add(kamar11);
        Kamar kamar12 = new Kamar("KA 2-2",1);
        kamars.add(kamar12);
        Kamar kamar13 = new Kamar("KA 2-3",1);
        kamars.add(kamar13);
        Kamar kamar14 = new Kamar("KA 2-4",1);
        kamars.add(kamar14);
        Kamar kamar15 = new Kamar("KA 2-5",1);
        kamars.add(kamar15);
        Kamar kamar16 = new Kamar("KA 2-6",1);
        kamars.add(kamar16);
        Kamar kamar17 = new Kamar("KA 2-7",1);
        kamars.add(kamar17);
        Kamar kamar18 = new Kamar("KA 2-8",1);
        kamars.add(kamar18);
        Kamar kamar19 = new Kamar("KA 2-9",1);
        kamars.add(kamar19);
        Kamar kamar20 = new Kamar("KA 2-10",1);
        kamars.add(kamar20);
        Kamar kamar21 = new Kamar("KA 3-1",1);
        kamars.add(kamar21);
        Kamar kamar22 = new Kamar("KA 3-2",1);
        kamars.add(kamar22);
        Kamar kamar23 = new Kamar("KA 3-3",1);
        kamars.add(kamar23);
        Kamar kamar24 = new Kamar("KA 3-4",1);
        kamars.add(kamar24);
        Kamar kamar25 = new Kamar("KA 3-5",1);
        kamars.add(kamar25);
        Kamar kamar26 = new Kamar("KA 3-6",1);
        kamars.add(kamar26);
        Kamar kamar27 = new Kamar("KA 3-7",1);
        kamars.add(kamar27);
        Kamar kamar28 = new Kamar("KA 3-8",1);
        kamars.add(kamar28);
        Kamar kamar29 = new Kamar("KA 3-9",1);
        kamars.add(kamar29);
        Kamar kamar30 = new Kamar("KA 3-10",1);
        kamars.add(kamar30);







        spinnerKamar = (Spinner) findViewById(R.id.spinnerKamar);
//        spinnerKamar.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        ArrayAdapter<Kamar> spinnerKamarAdapter = new ArrayAdapter<Kamar>(this, R.layout.spinner, kamars);
        spinnerKamarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKamar.setAdapter(spinnerKamarAdapter);

        editNama = findViewById(R.id.edtNamaPenghuni);
        editNoHp = findViewById(R.id.edtNoHp);
        editNoKtp = findViewById(R.id.edtNoKtp);
        editTglBayar = findViewById(R.id.edtTanggalBayar);

//        final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                  int dayOfMonth) {
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                String myFormat = "dd/MM/yyyy";
//                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
//                String a = myCalendar.getTime().toString();
//                Date d = null;
//                try {
//                    d = sdf.parse(a);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(d);
//                editTglBayar.setText(sdf.format(myCalendar.getTime()));
//            }
//
//        };
//        editTglBayar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(TambahPenghuni.this,datePickerListener,myCalendar
//                .get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });


        buttonSimpanPenghuni = findViewById(R.id.btnSimpanPenghuni);
        buttonSimpanPenghuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePenghuni();
            }
        });
    }

    private void savePenghuni() {
        String namaPenghuni = editNama.getText().toString();
        String noKamar = spinnerKamar.getSelectedItem().toString();
//        int noKamarA = spinnerKamar.getId();
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
