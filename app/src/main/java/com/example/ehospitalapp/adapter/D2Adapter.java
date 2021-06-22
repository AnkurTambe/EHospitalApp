package com.example.ehospitalapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.model.D2Model;

import java.util.ArrayList;

public class D2Adapter extends RecyclerView.Adapter<D2Adapter.ViewHolder> {

    ArrayList<D2Model> listItems = new ArrayList<D2Model>();
    Context context;

    public D2Adapter(ArrayList<D2Model> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_d2_rv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        D2Model listItem = listItems.get(position);
        holder.text1.setText(listItem.getTxt1());
        holder.text2.setText(listItem.getTxt2());
        holder.img.setImageResource(listItem.getImg());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text1;
        public TextView text2;
        public ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.d2_txt_1);
            text2 = (TextView) itemView.findViewById(R.id.d2_txt_2);
            img = (ImageView) itemView.findViewById(R.id.img_d2);

        }
    }

}