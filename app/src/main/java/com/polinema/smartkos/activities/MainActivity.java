package com.polinema.smartkos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.viewmodel.KamarViewModel;

import java.util.List;

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
    }

    public void buttonPenghuniClicked(View view) {
        Intent intent = new Intent(this,PenghuniActivity.class);
        startActivity(intent);
    }

    public void buttonPengeluaranClicked(View view) {
        Intent intent = new Intent(this,PengeluaranActivity.class);
        startActivity(intent);
    }
}
