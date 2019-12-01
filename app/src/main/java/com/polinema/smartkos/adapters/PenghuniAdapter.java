package com.polinema.smartkos.adapters;

import android.content.Context;
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
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.viewmodel.PenghuniViewModel;

import java.util.ArrayList;
import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.PenghuniHolder> {
    private List<Penghuni> penghunis = new ArrayList<>();
    private Context mCtx;
    private OnItemClickListener mListener;
    private OnMenuDeleteClickListener mMenuDeleteListener;
    private OnMenuExtendClickListener mMenuExtendListener;
    private PenghuniViewModel penghuniViewModel;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public interface OnMenuDeleteClickListener{
        void onMenuDeleteClick(int position);
    }

    public interface OnMenuExtendClickListener{
        void onMenuExtendClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public void setOnMenuDeleteClickListener(OnMenuDeleteClickListener listener){
        mMenuDeleteListener = listener;
    }

    public void setOnMenuExtendClickListener(OnMenuExtendClickListener listener){
        mMenuExtendListener = listener;
    }

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

        /*holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(mCtx, holder.buttonViewOption);
                popupMenu.inflate(R.menu.menu_more);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.extend:
                                break;
                            case R.id.delete:
                                removeAt(position);
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });*/
    }

    public void removeAt(int position) {
        penghuniViewModel.delete(penghunis.get(position));
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

            buttonViewOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    PopupMenu popupMenu = new PopupMenu(mCtx, buttonViewOption);
                    popupMenu.inflate(R.menu.menu_more);

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.extend:
                                    if (mMenuExtendListener != null) {
                                        int positionTambah = getAdapterPosition();
                                        if (positionTambah != RecyclerView.NO_POSITION) {
                                            mMenuExtendListener.onMenuExtendClick(positionTambah);
                                        }
                                    }
                                    break;
                                case R.id.delete:
                                    if (mMenuDeleteListener != null){
                                        int position = getAdapterPosition();
                                        if (position != RecyclerView.NO_POSITION) {
                                            mMenuDeleteListener.onMenuDeleteClick(position);
                                        }
                                    }
                                    break;
                            }
                            return false;
                        }
                    });

                    popupMenu.show();
                }
            });
        }
    }


}
