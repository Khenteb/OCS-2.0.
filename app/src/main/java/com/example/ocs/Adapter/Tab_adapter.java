package com.example.ocs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ocs.R;

import java.util.ArrayList;

public class Tab_adapter extends RecyclerView.Adapter<Tab_adapter.MyViewHolder> {
    Context context;
    ArrayList<CategoryModel> categoryModels;

    public Tab_adapter(Context context, ArrayList<CategoryModel> categoryModels){
        this.context=context;
        this.categoryModels=categoryModels;
    }

    @NonNull
    @Override
    public Tab_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_tab,parent,false);
        return new Tab_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab_adapter.MyViewHolder holder, int position) {

        holder.tvName.setText(categoryModels.get(position).getName());
        holder.tvCost.setText(categoryModels.get(position).getCost());
        holder.imageView.setImageResource(categoryModels.get(position).getImage());


    }

    @Override
    public int getItemCount() {

        return categoryModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tvCost;
        Button btn1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.imageView);
            tvName =itemView.findViewById(R.id.textView2);
            tvCost = itemView.findViewById(R.id.textView);
            btn1 = itemView.findViewById(R.id.button);
        }
    }

}
