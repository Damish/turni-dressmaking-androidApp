package com.damishs.turni_dressmaking;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Models.Order;

public class ManageOrders extends AppCompatActivity {

    DatabaseReference databaseOrders;
    List<Order> MyOrdersList;
    ListView listViewAllOrders;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_orders);

        listViewAllOrders = findViewById(R.id.listViewAllOrders);
        MyOrdersList = new ArrayList<>();

        databaseOrders = FirebaseDatabase.getInstance().getReference("orders");

        databaseOrders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot orderSnapShot : snapshot.getChildren()) {
                    final Order order = orderSnapShot.getValue(Order.class);


                    Order order1 = new Order(order.getId(), order.getCustomerName(),order.getDate(),
                            order.getItem1Price(),order.getItem2Price(),order.getItem3Price(),
                            order.getItem4Price(),order.getItem5Price(),order.getTotal(),order.getDiscount());
                    MyOrdersList.add(order1);

                    ArrayAdapter adapter = new OrdersList(ManageOrders.this, MyOrdersList);
                    listViewAllOrders.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }


}
