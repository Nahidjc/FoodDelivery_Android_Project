package com.example.fooddelivery.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter  extends RecyclerView.Adapter<HomeRecyclerAdapter.viewHolder> {
    public HomeRecyclerAdapter(List<Restaurant> allRestaurants) {
        this.allRestaurants = allRestaurants;
    }

    List<Restaurant> allRestaurants;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item,parent,false);
       return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Restaurant current = allRestaurants.get(position);
        holder.restaurantName.setText(current.getRestaurantName());
        holder.restaurantDescription.setText(current.getRestaurantDescription());
        Picasso.get().load(current.getRestaurantImgUrl()).into(holder.restaurantImage);
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
        ImageView restaurantImage;
        TextView restaurantName,restaurantDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restaurantImageView);
            restaurantName= itemView.findViewById(R.id.restaurantNameView);
            restaurantDescription = itemView.findViewById(R.id.restaurantDescriptionView);
        }
    }
}
