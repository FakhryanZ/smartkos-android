package com.polinema.smartkos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.MyViewHolder>{

    private final LayoutInflater mInflater;
    private List<PenghuniEntity> mPenghuniEntities;

    public PenghuniAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void SetListPenghuni(List<PenghuniEntity> penghuniEntities){
        mPenghuniEntities = penghuniEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.item_penghuni,parent,false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPenghuniEntities==null?0:mPenghuniEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomorKamar,namaPenghuni,waktuSewa
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomorKamar = itemView.findViewById(R.id.nomorKamar);
            namaPenghuni = itemView.findViewById(R.id.namaPenghuni);
            waktuSewa = itemView.findViewById(R.id.waktuSewa);
        }
    }
}
