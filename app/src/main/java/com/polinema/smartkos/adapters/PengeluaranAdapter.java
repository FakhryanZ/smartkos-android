package com.polinema.smartkos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.pengeluaran.Pengeluaran;

import java.util.ArrayList;
import java.util.List;

public class PengeluaranAdapter extends RecyclerView.Adapter<PengeluaranAdapter.PengeluaranHolder> {
    private List<Pengeluaran> pengeluarans = new ArrayList<>();

    @NonNull
    @Override
    public PengeluaranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pengeluaran_bulan_ini,parent,false);
        return new PengeluaranHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PengeluaranHolder holder, int position) {
        Pengeluaran currentPengeluaran = pengeluarans.get(position);
        holder.tvJenis.setText(currentPengeluaran.getJenisPengeluaran());
        holder.tvJumlah.setText(String.valueOf(currentPengeluaran.getBiaya()));
    }

    @Override
    public int getItemCount() {
        return pengeluarans.size();
    }

    public void setPengeluarans(List<Pengeluaran> pengeluarans) {
        this.pengeluarans = pengeluarans;
        notifyDataSetChanged();
    }

    public Pengeluaran getPengeluaranAt(int position) {
        return pengeluarans.get(position);
    }

    class PengeluaranHolder extends RecyclerView.ViewHolder {
        private TextView tvJenis;
        private TextView tvJumlah;

        public PengeluaranHolder(@NonNull View itemView) {
            super(itemView);
            tvJenis = itemView.findViewById(R.id.text_view_jenis);
            tvJumlah = itemView.findViewById(R.id.text_view_jumlah);
        }
    }
}
