package com.damishs.turni_dressmaking;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import Models.Order;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseOrders;
    EditText editTextCustomerName, editTextItem1Price, editTextItem2Price, editTextItem3Price, editTextItem4Price, editTextItem5Price, editTextDiscount, editTextTotal;
    Button button, btnGotoManageOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Write a message to the database
        databaseOrders = FirebaseDatabase.getInstance().getReference("orders");

        editTextCustomerName = findViewById(R.id.editTextCustomerName);
        editTextItem1Price = findViewById(R.id.editTextItem1Price);
        editTextItem2Price = findViewById(R.id.editTextItem2Price);
        editTextItem3Price = findViewById(R.id.editTextItem3Price);
        editTextItem4Price = findViewById(R.id.editTextItem4Price);
        editTextItem5Price = findViewById(R.id.editTextItem5Price);
        editTextDiscount = findViewById(R.id.editTextDiscount);
        editTextTotal = findViewById(R.id.editTextTotal);


        button = findViewById(R.id.button);
        btnGotoManageOrders = findViewById(R.id.btnGotoManageOrders);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrder(""
                        , editTextCustomerName.getText().toString().trim()
                        , new Date().toString() //set current date and time
                        , Integer.parseInt(editTextItem1Price.getText().toString().trim())
                        , Integer.parseInt(editTextItem2Price.getText().toString().trim())
                        , Integer.parseInt(editTextItem3Price.getText().toString().trim())
                        , Integer.parseInt(editTextItem4Price.getText().toString().trim())
                        , Integer.parseInt(editTextItem5Price.getText().toString().trim())
                        , Integer.parseInt(editTextDiscount.getText().toString())
                        , Integer.parseInt(editTextTotal.getText().toString()));

                editTextCustomerName.setText("");
                editTextItem1Price.setText("");
                editTextItem2Price.setText("");
                editTextItem3Price.setText("");
                editTextItem4Price.setText("");
                editTextItem5Price.setText("");
                editTextDiscount.setText("");
                editTextTotal.setText("");
            }
        });

        btnGotoManageOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToManageOrders = new Intent(MainActivity.this, ManageOrders.class);
                startActivity(intentToManageOrders);
            }
        });
    }

    public void addOrder(
            String id1,
            String customerName,
            String date,
            int item1Price,
            int item2Price,
            int item3Price,
            int item4Price,
            int item5Price,
            int total,
            int discount) {

        if (!TextUtils.isEmpty(customerName)) {


            //unique id is generated
            String id = databaseOrders.push().getKey();
            Order order = new Order(id, customerName, date, item1Price, item2Price, item3Price, item4Price, item5Price, total, discount);

            //overwrite data to created id
            databaseOrders.child(id).setValue(order);
            Toast.makeText(this, "Order added", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "You should enter name!!!", Toast.LENGTH_SHORT).show();
        }

    }


}
