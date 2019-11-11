package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.polinema.smartkos.R;
import com.polinema.smartkos.adapters.PengeluaranAdapter;
import com.polinema.smartkos.adapters.TabAdapter;
import com.polinema.smartkos.data.pengeluaran.Pengeluaran;
import com.polinema.smartkos.viewModel.PengeluaranViewModel;

import java.util.List;

public class PengeluaranActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    public static final int ADD_NOTE_REQUEST = 1;

    private ViewPager viewPager;
    private PengeluaranViewModel pengeluaranViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        RecyclerView recyclerView = findViewById(R.id.recyclerPengeluaran);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PengeluaranAdapter adapter = new PengeluaranAdapter();
        recyclerView.setAdapter(adapter);

        pengeluaranViewModel = ViewModelProviders.of(this).get(PengeluaranViewModel.class);
        pengeluaranViewModel.getAllPengeluaran().observe(this, new Observer<List<Pengeluaran>>() {
            @Override
            public void onChanged(List<Pengeluaran> pengeluarans) {
                adapter.setPengeluarans(pengeluarans);
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
                pengeluaranViewModel.delete(adapter.getPengeluaranAt(viewHolder.getAdapterPosition()));
                Toast.makeText(PengeluaranActivity.this, "Item terhapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setLetterSpacing((float) 0.1);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Bulan Ini"));
        tabLayout.addTab(tabLayout.newTab().setText("Semua Bulan"));

        viewPager = findViewById(R.id.fragment_layout);
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        FloatingActionButton buttonAdd = findViewById(R.id.add_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PengeluaranActivity.this,TambahPengeluaran.class);
                startActivityForResult(intent,ADD_NOTE_REQUEST);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String jenis = data.getStringExtra(TambahPengeluaran.EXTRA_JENIS);
            int jumlah = data.getIntExtra(TambahPengeluaran.EXTRA_JUMLAH, 0);

            Pengeluaran pengeluaran = new Pengeluaran(jenis,jumlah);
            pengeluaranViewModel.insert(pengeluaran);

            Toast.makeText(this, "Pengeluaran Tersimpan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Gagal Disimpan", Toast.LENGTH_SHORT).show();
        }
    }
}
