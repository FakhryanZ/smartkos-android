package com.polinema.smartkos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;

import java.util.ArrayList;
import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.PenghuniHolder> {
    private List<Penghuni> penghunis = new ArrayList<>();
    private Context mCtx;

    @NonNull
    @Override
    public PenghuniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mCtx = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.penghuni_item, parent, false);
        return new PenghuniHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull final PenghuniHolder holder, final int position) {
        Penghuni currentPenghuni = penghunis.get(position);
        holder.tvNoKamar.setText(currentPenghuni.getIdKamar());
        holder.tvNamaPenghuni.setText(currentPenghuni.getNama());
        holder.tvLamaSewa.setText(currentPenghuni.getTglMasuk().toString());

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(mCtx, holder.buttonViewOption);
                popupMenu.inflate(R.menu.menu_more);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.edit_profile:
                                break;
                            case R.id.extend:
                                break;
                            case R.id.delete:
//                                instance.penghuniDao().delete(penghunis.get(position));
                                removeAt(holder.getAdapterPosition());
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    public void removeAt(int position) {
        penghunis.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,penghunis.size());
    }

    public Penghuni getPenghuniAt(int position) {
        return penghunis.get(position);
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
        private Button buttonViewOption;

        public PenghuniHolder(@NonNull View itemView) {
            super(itemView);
            tvNoKamar = itemView.findViewById(R.id.tvNoKamar);
            tvNamaPenghuni = itemView.findViewById(R.id.tvNamaPenghuni);
            tvLamaSewa = itemView.findViewById(R.id.tvLamaSewa);
            buttonViewOption = itemView.findViewById(R.id.button_more);
        }
    }


}
