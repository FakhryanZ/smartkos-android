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
    public static final String EXTRA_NOKAMAR=
            "com.polinema.smartkos.activities.EXTRA_NOKAMAR";
    public static final String EXTRA_NOHP=
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

        List<Kamar> kamars= new ArrayList<>();
        Kamar kamar1 = new Kamar("A1",1);
        kamars.add(kamar1);
        Kamar kamar2 = new Kamar("A2",1);
        kamars.add(kamar2);
        Kamar kamar3 = new Kamar("A3",1);
        kamars.add(kamar3);

        spinnerKamar = (Spinner) findViewById(R.id.spinnerKamar);
//        spinnerKamar.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        ArrayAdapter<Kamar> spinnerKamarAdapter = new ArrayAdapter<Kamar>(this,R.layout.spinner,kamars);
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

    private void savePenghuni(){
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
