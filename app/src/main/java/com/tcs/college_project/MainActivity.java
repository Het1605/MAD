package com.tcs.college_project;

import static com.tcs.college_project.R.id.btnConfirmAll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> items;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Button btnConfirmAll = findViewById(R.id.btnConfirmAll); // Get confirm button

        DatabaseHelper dbHelper = new DatabaseHelper(this);



        // Sample items list
        items = new ArrayList<>();
        items.add(new Item("Burger", "Fast food", R.drawable.img));
        items.add(new Item("Pizza", "Italian food", R.drawable.img_1));
        items.add(new Item("Colddrink", "Beverage", R.drawable.img_2));
        items.add(new Item("Pasta", "Delicious pasta", R.drawable.img_3));
        items.add(new Item("Noodles", "Tasty noodles", R.drawable.img_4));

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);

        // Confirm button click event
        btnConfirmAll.setOnClickListener(v -> {
            for (Item item : items) {
                if (item.getCount() > 0) {  // Store only selected items
                    dbHelper.insertOrder(item.getName(), item.getEmail(), item.getImage(), item.getCount());
                }
            }
            Toast.makeText(MainActivity.this, "Order Confirmed!", Toast.LENGTH_SHORT).show();
        });
    }

    // Method to save selected items
    private void saveOrder() {
        StringBuilder orderSummary = new StringBuilder("Order Summary:\n");

        for (Item item : items) {
            if (item.getCount() > 0) { // Only save items that have been selected
                orderSummary.append(item.getName()).append(": ").append(item.getCount()).append("\n");
            }
        }

        Log.d("Order", orderSummary.toString()); // Log order (Replace with database storage)
    }
}