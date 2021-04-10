package com.example.fooddelivery.ui.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.model.DataController;
import com.example.fooddelivery.model.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {

    List<MenuItem> allRestaurants;
    public MenuAdapter(List<MenuItem> allRestaurants) {
        this.allRestaurants = allRestaurants;
    }
    @NonNull
    @Override
    public MenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return  new MenuAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.viewHolder holder, int position) {
        MenuItem current = allRestaurants.get(position);


    }

    @Override
    public int getItemCount() {
        if(allRestaurants==null || allRestaurants.size()==0){
            return 0;
        }else{
            return allRestaurants.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView menuItemName, menuDescription,priceTextView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            menuItemName = itemView.findViewById(R.id.itemName);
            menuDescription = itemView.findViewById(R.id.itemDescription);
            priceTextView = itemView.findViewById(R.id.itemPrice);
        }
    }
}
