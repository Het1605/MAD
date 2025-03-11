package com.tcs.college_project;

import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, emailView, itemCount;
    Button btnPlus, btnMinus,btnConfirm;  // ✅ Added buttons

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        emailView = itemView.findViewById(R.id.email);
        itemCount = itemView.findViewById(R.id.item_count);  // ✅ Count TextView
        btnPlus = itemView.findViewById(R.id.btn_increase);      // ✅ + Button
        btnMinus = itemView.findViewById(R.id.btn_decrease);    // ✅ - Button

    }
}