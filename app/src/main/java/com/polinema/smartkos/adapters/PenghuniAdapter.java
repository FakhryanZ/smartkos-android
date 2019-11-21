package com.polinema.smartkos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.PenghuniHolder> {
    private List<Penghuni> penghunis = new ArrayList<>();

    @NonNull
    @Override
    public PenghuniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.penghuni_item, parent, false);
        return new PenghuniHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PenghuniHolder holder, int position) {
        Penghuni currentPenghuni = penghunis.get(position);
        holder.tvNoKamar.setText(currentPenghuni.getIdKamar());
        holder.tvNamaPenghuni.setText(currentPenghuni.getNama());
        holder.tvLamaSewa.setText(currentPenghuni.getTglMasuk());
    }

    @Override
    public int getItemCount() {
        return penghunis.size();
    }

    public void setPenghunis(List<Penghuni> penghunis){
        this.penghunis = penghunis;
        notifyDataSetChanged();
    }

    class PenghuniHolder extends RecyclerView.ViewHolder {
        private TextView tvNoKamar;
        private TextView tvNamaPenghuni;
        private TextView tvLamaSewa;

        public PenghuniHolder(@NonNull View itemView) {
            super(itemView);
            tvNoKamar = itemView.findViewById(R.id.tvNoKamar);
            tvNamaPenghuni = itemView.findViewById(R.id.tvNamaPenghuni);
            tvLamaSewa = itemView.findViewById(R.id.tvLamaSewa);
        }
    }
}
