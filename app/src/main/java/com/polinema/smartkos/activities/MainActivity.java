package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.polinema.smartkos.R;
import com.polinema.smartkos.viewmodel.KamarViewModel;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private KamarViewModel kamarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());

        TextView textViewTanggal = findViewById(R.id.txtBulan);
        textViewTanggal.setText(currentDate);

//        String totalBiaya = smartkos.db.showTotalBiaya();
    }

//    public int showTotalBiaya(){
//        int total = 0;
//        SQLiteDatabase db =
//        Cursor c = db.rawQuery("SELECT SUM(biaya) as valTotalMonth " +
//                "FROM Pengeluaran WHERE strftime('%Y', tanggal)= strftime('%Y', date('now')) AND strftime('%m',tanggal) = strftime('%m',date('now'))");
//        if (c.moveToFirst()){
//            total = c.getInt(0);
//        }
//        return total;
//    }

    public void buttonPenghuniClicked(View view) {
        Intent intent = new Intent(this,PenghuniActivity.class);
        startActivity(intent);
    }

    public void buttonPengeluaranClicked(View view) {
        Intent intent = new Intent(this,PengeluaranActivity.class);
        startActivity(intent);
    }
}
