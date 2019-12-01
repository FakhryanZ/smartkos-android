package com.polinema.smartkos.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.polinema.smartkos.R;
import com.polinema.smartkos.activities.TambahPengeluaran;
import com.polinema.smartkos.adapters.PengeluaranBulanIniAdapter;
import com.polinema.smartkos.data.pengeluaran.Pengeluaran;
import com.polinema.smartkos.viewmodel.PengeluaranViewModel;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;


public class PengeluaranBulanIni extends Fragment {
    private PengeluaranViewModel pengeluaranViewModel;
    public static final int ADD_NOTE_REQUEST = 1;

    public PengeluaranBulanIni() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengeluaran_bulan_ini, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_pengeluaran_bulan_ini);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());

        TextView textViewTanggal = view.findViewById(R.id.text_view_tanggal);
        textViewTanggal.setText(currentDate);

        final PengeluaranBulanIniAdapter adapter = new PengeluaranBulanIniAdapter();
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
                Toast.makeText(getActivity(), "Item terhapus", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        FloatingActionButton buttonAdd = view.findViewById(R.id.add_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TambahPengeluaran.class);
                startActivityForResult(intent,ADD_NOTE_REQUEST);
            }
        });
        return view;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            String jenis = data.getStringExtra(TambahPengeluaran.EXTRA_JENIS);
            int jumlah = data.getIntExtra(TambahPengeluaran.EXTRA_JUMLAH, 0);
            String tanggal = data.getStringExtra(TambahPengeluaran.EXTRA_TANGGAL);
            Pengeluaran pengeluaran = new Pengeluaran(jenis,jumlah,tanggal);
            pengeluaranViewModel.insert(pengeluaran);

            Toast.makeText(getActivity(), "Pengeluaran Tersimpan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Gagal Disimpan", Toast.LENGTH_SHORT).show();
        }
    }

}
