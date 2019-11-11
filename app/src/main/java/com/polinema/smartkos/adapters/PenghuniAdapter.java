package com.polinema.smartkos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polinema.smartkos.R;
import com.polinema.smartkos.data.penghuni.Penghuni;

import java.util.List;

public class PenghuniAdapter extends RecyclerView.Adapter<PenghuniAdapter.MyViewHolder>{

    private final LayoutInflater mInflater;
    private List<Penghuni> mPenghuniEntities;

    public PenghuniAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void SetListPenghuni(List<Penghuni> penghuniEntities){
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
        if (mPenghuniEntities != null) {
            Penghuni current = mPenghuniEntities.get(position);
            holder.namaPenghuni.setText(current.getNama());
        } else {
            holder.namaPenghuni.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        return mPenghuniEntities==null?0:mPenghuniEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namaPenghuni;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaPenghuni = itemView.findViewById(R.id.showNamaPenghuni);
        }
    }
}
