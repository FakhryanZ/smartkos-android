package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.adapters.PenghuniAdapter;

public class PenghuniActivity extends AppCompatActivity {
    Button buttonMore;
//    private PenghuniViewModel penghuniViewModel;
    private RecyclerView rvPenghuni;
    private PenghuniAdapter penghuniAdapter;

    private TextView showNomorKamar, showNamaPenghuni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penghuni);

        rvPenghuni = findViewById(R.id.recyclerPenghuni);
        final PenghuniAdapter adapter = new PenghuniAdapter(this);
        rvPenghuni.setAdapter(adapter);
        rvPenghuni.setLayoutManager(new LinearLayoutManager(this));

//        buttonMore = (Button)findViewById(R.id.button_more);
//        buttonMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(PenghuniActivity.this,buttonMore);
//                popupMenu.getMenuInflater().inflate(R.menu.menu_more,popupMenu.getMenu());
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        return false;
//                    }
//                });
//                popupMenu.show();
//
//            }
//        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        Spinner spinnerCategory = (Spinner) findViewById(R.id.category);
        String[] categories = new String[]{
                "Nomor Kamar",
                "Nama",
                "Waktu Sewa"
        };
        ArrayAdapter<String> spinnerCategoryAdapter = new ArrayAdapter<String>(this,R.layout.spinner,categories);
        spinnerCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(spinnerCategoryAdapter);

        Spinner spinnerOrder = (Spinner) findViewById(R.id.order);
        String[] orders = new String[]{
                "A-Z",
                "Z-A"
        };
        ArrayAdapter<String> spinnerOrderAdapter = new ArrayAdapter<String>(this,R.layout.spinner,orders);
        spinnerOrderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrder.setAdapter(spinnerOrderAdapter);
    }

//    private void initiateComponent(View mView) {
//        showNamaPenghuni = mView.findViewById(R.id.showNamaPenghuni);
//        rvPenghuni = findViewById(R.id.recyclerPenghuni);
//        rvPenghuni.setLayoutManager(new LinearLayoutManager(this));
//        penghuniAdapter = new PenghuniAdapter(this);
//        rvPenghuni.setAdapter(penghuniAdapter);
//
//        penghuniViewModel = ViewModelProviders.of(this).get(PenghuniViewModel.class);
//        penghuniViewModel.GetListPenghuni().observe(this, new Observer<List<Penghuni>>() {
//            @Override
//            public void onChanged(List<Penghuni> penghuni) {
//                penghuniAdapter.SetListPenghuni(penghuni);
//            }
//        });
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar,menu);

        return true;
    }

    public void buttonAddClicked(View view) {
        Intent intent = new Intent(this,TambahPenghuni.class);
        startActivity(intent);
    }
}
