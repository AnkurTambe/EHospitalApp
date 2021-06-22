package com.example.ehospitalapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.fragment.D2Fragment;
import com.example.ehospitalapp.model.D1Model;

import java.util.ArrayList;

public class D1Adapter extends RecyclerView.Adapter<D1Adapter.ViewHolder> {

    ArrayList<D1Model> listItems = new ArrayList<D1Model>();
    Context context;
    String t;

    public D1Adapter(ArrayList<D1Model> listItems, Context context, String t) {
        this.listItems = listItems;
        this.context = context;
        this.t = t;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_d1_rv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        D1Model listItem = listItems.get(position);
        holder.text1.setText(listItem.getTxt1());
        holder.text2.setText(listItem.getTxt2());
        holder.text3.setText(listItem.getTxt3());
        holder.img.setImageResource(listItem.getImg());

        D2Fragment d2Fragment = new D2Fragment();

        Bundle b = new Bundle();
        b.putString("mainT", t);
        b.putString("typeD23", listItem.getTxt3());
        d2Fragment.setArguments(b);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_detail,
                        d2Fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text1;
        public TextView text2;
        public TextView text3;
        public ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.d1_txt_1);
            text2 = (TextView) itemView.findViewById(R.id.d1_txt_2);
            text3 = (TextView) itemView.findViewById(R.id.d1_txt_3);
            img = (ImageView) itemView.findViewById(R.id.img_d1);

        }
    }

}