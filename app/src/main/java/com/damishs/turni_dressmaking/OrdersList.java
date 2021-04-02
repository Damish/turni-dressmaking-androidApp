package com.damishs.turni_dressmaking;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import Models.Order;

public class OrdersList extends ArrayAdapter<Order> {


    private Activity context;
    private List<Order> ordersList;


    public OrdersList(Activity context, List<Order> ordersList) {
        super(context, R.layout.list_layout, ordersList);
        this.context = context;
        this.ordersList = ordersList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.my_order_list_item,null,true);


        TextView txtViewOrderId =listViewItem.findViewById(R.id.txtViewOrderId);
        TextView txtViewOrdername =listViewItem.findViewById(R.id.txtViewOrdername);


        Order order = ordersList.get(position);

        txtViewOrderId.setText(order.getId());
        txtViewOrdername.setText(order.getCustomerName());

        return listViewItem;

    }



}
