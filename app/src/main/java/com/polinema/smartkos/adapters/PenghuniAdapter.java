package com.polinema.smartkos.adapters;

import android.content.Context;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.AppDatabase;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewmodel.PenghuniViewModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.PenghuniHolder> {
    private List<Penghuni> penghunis = new ArrayList<>();
    private AppDatabase db;

    private PenghuniViewModel penghuniViewModel;

    @NonNull
    @Override
    public PenghuniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.penghuni_item, parent, false);
        return new PenghuniHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PenghuniAdapter.PenghuniHolder holder, int position) {
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

    public Penghuni getPenghuniAt(int position){
        return penghunis.get(position);
    }

    public void onDeletePenghuni(RecyclerView.ViewHolder viewHolder){
        penghuniViewModel.delete(getPenghuniAt(viewHolder.getAdapterPosition()));
    }

    class PenghuniHolder extends RecyclerView.ViewHolder {
        private TextView tvNoKamar;
        private TextView tvNamaPenghuni;
        private TextView tvLamaSewa;
        private Button btnMore;

        public PenghuniHolder(@NonNull final View itemView) {
            super(itemView);
            tvNoKamar = itemView.findViewById(R.id.tvNoKamar);
            tvNamaPenghuni = itemView.findViewById(R.id.tvNamaPenghuni);
            tvLamaSewa = itemView.findViewById(R.id.tvLamaSewa);
            btnMore = itemView.findViewById(R.id.button_more);

            btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(btnMore.getContext(), itemView);

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.extend:

                                    break;
                                case R.id.delete:
                                    onDeletePenghuni();
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.inflate(R.menu.menu_more);
                    popupMenu.setGravity(Gravity.RIGHT);
                    popupMenu.show();
                }
            });
        }
    }
}
