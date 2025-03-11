package com.tcs.college_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item> items;
    DatabaseHelper databaseHelper;  // ✅ Database Helper

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
        databaseHelper = new DatabaseHelper(context);  // ✅ Initialize DB
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = items.get(position);

        holder.nameView.setText(item.getName());
        holder.emailView.setText(item.getEmail());
        holder.imageView.setImageResource(item.getImage());
        holder.itemCount.setText(String.valueOf(item.getCount()));

        // Increase item count
        holder.btnPlus.setOnClickListener(v -> {
            item.setCount(item.getCount() + 1);
            holder.itemCount.setText(String.valueOf(item.getCount()));
            notifyItemChanged(position);
        });

        // Decrease item count (not below 0)
        holder.btnMinus.setOnClickListener(v -> {
            if (item.getCount() > 0) {
                item.setCount(item.getCount() - 1);
                holder.itemCount.setText(String.valueOf(item.getCount()));
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}