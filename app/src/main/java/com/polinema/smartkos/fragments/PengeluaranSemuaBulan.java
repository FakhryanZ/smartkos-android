package com.polinema.smartkos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.polinema.smartkos.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class PengeluaranSemuaBulan extends Fragment {

    public PengeluaranSemuaBulan() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pengeluaran_semua_bulan, container,false);

        Spinner spinnerListBulan = (Spinner) v.findViewById(R.id.list_bulan);
        String[] months = new String[]{
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
        };
        ArrayAdapter<String> spinnerListBulanAdapter = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,months);
        spinnerListBulanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerListBulan.setAdapter(spinnerListBulanAdapter);

        Spinner spinnerOrder = (Spinner) v.findViewById(R.id.order);
        String[] orders = new String[]{
                "A-Z",
                "Z-A"
        };
        ArrayAdapter<String> spinnerOrderAdapter = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,orders);
        spinnerOrderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrder.setAdapter(spinnerOrderAdapter);

        return v;
    }


}
