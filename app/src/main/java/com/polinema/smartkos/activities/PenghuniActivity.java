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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.polinema.smartkos.R;
import com.polinema.smartkos.adapters.PenghuniAdapter;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewModel.PenghuniViewModel;

import java.util.Date;
import java.util.List;

public class PenghuniActivity extends AppCompatActivity {
    public static final int ADD_PENGHUNI_REQUEST = 1;
    private PenghuniViewModel penghuniViewModel;
    Button buttonMore;
    final PenghuniAdapter adapter = new PenghuniAdapter();
    private RecyclerView.ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penghuni);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

//        final PenghuniAdapter adapter = new PenghuniAdapter();
        recyclerView.setAdapter(adapter);

//        buttonMore = findViewById(R.id.button_more);
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


        penghuniViewModel = ViewModelProviders.of(this).get(PenghuniViewModel.class);
        penghuniViewModel.getAllPenghuni().observe(this, new Observer<List<Penghuni>>() {
            @Override
            public void onChanged(@Nullable List<Penghuni> penghunis) {
                //update RecyclerView
                adapter.setPenghunis(penghunis);
            }
        });

        FloatingActionButton buttonAddPenghuni = findViewById(R.id.addButton);
        buttonAddPenghuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PenghuniActivity.this, TambahPenghuni.class);
                startActivityForResult(intent, ADD_PENGHUNI_REQUEST);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                penghuniViewModel.delete(adapter.getPenghuniAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getApplicationContext(), "Item terhapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }

//    public void onClick(View view) {
//        PopupMenu popupMenu = new PopupMenu(this, view);
//        popupMenu.inflate(R.menu.menu_more);
//
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.edit_profile:
//                        break;
//                    case R.id.extend:
//                        break;
//                    case R.id.delete:
//                        penghuniViewModel.delete(adapter.getPenghuniAt(viewHolder.getAdapterPosition()));
//                        break;
//                }
//                return false;
//            }
//        });
//
//        popupMenu.show();
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar,menu);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_PENGHUNI_REQUEST && resultCode == RESULT_OK) {
            String nama = data.getStringExtra(TambahPenghuni.EXTRA_NAMA);
            String noHp = data.getStringExtra(TambahPenghuni.EXTRA_NOHP);
            String noKtp = data.getStringExtra(TambahPenghuni.EXTRA_NOKTP);
            String noKamar = data.getStringExtra(TambahPenghuni.EXTRA_NOKAMAR);
            Date tglBayar = new Date(data.getStringExtra(TambahPenghuni.EXTRA_TGLBAYAR));


            Penghuni penghuni = new Penghuni(nama, noHp, noKtp, tglBayar, noKamar);
            penghuniViewModel.insert(penghuni);

            Toast.makeText(this, "Penghuni Tersimpan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Penghuni tidak tersimpan", Toast.LENGTH_SHORT).show();
        }
    }
}
