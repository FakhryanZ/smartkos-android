package com.polinema.smartkos.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.activities.PerpanjangSewaPenghuni;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewmodel.PenghuniViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.PenghuniHolder> {
    private List<Penghuni> penghunis = new ArrayList<>();
    private Context mCtx;
    private OnItemClickListener mListener;
    private PenghuniViewModel viewModel;

    Button buttonMore;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public PenghuniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mCtx = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.penghuni_item, parent, false);
        buttonMore = itemView.findViewById(R.id.button_more);
        return new PenghuniHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PenghuniHolder holder, int position) {
        final Penghuni currentPenghuni = penghunis.get(position);
        holder.tvNoKamar.setText(currentPenghuni.getIdKamar());
        holder.tvNamaPenghuni.setText(currentPenghuni.getNama());
        String unconvert = currentPenghuni.getTglHabis().toString();
        String converted = unconvert.replace("00:00:00 EDT","");
        holder.tvLamaSewa.setText(converted);

        final PenghuniAdapter caller = this;

        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(mCtx,buttonMore);
                popupMenu.getMenuInflater().inflate(R.menu.menu_more,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.perpanjang:

                                Date tglHabis = currentPenghuni.getTglHabis();

                                Toast.makeText(mCtx, tglHabis.toString(), Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(mCtx, PerpanjangSewaPenghuni.class);
                                intent.putExtra("CurrentPenghuni",currentPenghuni);
                                mCtx.startActivity(intent);
                                break;
                            case R.id.hapus:
                                caller.removePenghuni(currentPenghuni);
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();

            }
        });

    }

    private void removePenghuni(Penghuni currentPenghuni)
    {
        this.viewModel.delete(currentPenghuni);
    }

    @Override
    public int getItemCount() {
        return penghunis.size();
    }

    public void setPenghunis(List<Penghuni> penghunis){
        this.penghunis = penghunis;
        notifyDataSetChanged();
    }

    public Penghuni getPenghuniAt(int position) {
        return penghunis.get(position);
    }

    public void setViewModel(PenghuniViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public PenghuniViewModel getViewModel() {
        return viewModel;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
