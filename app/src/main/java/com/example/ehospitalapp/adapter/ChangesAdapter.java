package com.example.ehospitalapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.model.D1Model;

import java.util.ArrayList;

public class ChangesAdapter extends RecyclerView.Adapter<ChangesAdapter.ViewHolder> {

    ArrayList<D1Model> listItems = new ArrayList<D1Model>();
    Context context;

    public ChangesAdapter(ArrayList<D1Model> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailAddressIntent = new Intent(Intent.ACTION_SENDTO);
                emailAddressIntent.setData(Uri.parse("mailto:" + listItem.getTxt3()));
                v.getContext().startActivity(emailAddressIntent);
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