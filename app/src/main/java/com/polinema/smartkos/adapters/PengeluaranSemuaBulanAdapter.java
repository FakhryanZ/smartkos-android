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

public class PengeluaranSemuaBulanAdapter extends RecyclerView.Adapter<PengeluaranSemuaBulanAdapter.PengeluaranHolder> {
    private List<Pengeluaran> pengeluarans = new ArrayList<>();

    @NonNull
    @Override
    public PengeluaranSemuaBulanAdapter.PengeluaranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pengeluaran_semua_bulan,parent,false);
        return new PengeluaranSemuaBulanAdapter.PengeluaranHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PengeluaranSemuaBulanAdapter.PengeluaranHolder holder, int position) {
        Pengeluaran currentPengeluaran = pengeluarans.get(position);
        holder.tvBulan.setText(currentPengeluaran.getJenisPengeluaran());
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
        private TextView tvBulan;
        private TextView tvJumlah;

        public PengeluaranHolder(@NonNull View itemView) {
            super(itemView);
            tvBulan = itemView.findViewById(R.id.text_view_bulan);
            tvJumlah = itemView.findViewById(R.id.text_view_jumlahPerBulan);
        }
    }
}
