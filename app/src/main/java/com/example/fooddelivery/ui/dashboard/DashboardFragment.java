package com.example.fooddelivery.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class DashboardFragment extends Fragment {

  FirebaseUser user;
  ImageView userprofile;
  TextView emailText,nameText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        userprofile = root.findViewById(R.id.imageView);
        emailText = root.findViewById(R.id.emailID);
        nameText = root.findViewById(R.id.nameID);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            emailText.setText("Email:"+user.getEmail());
            nameText.setText("Name:"+user.getDisplayName());
            Picasso.get().load(user.getPhotoUrl()).fit().into(userprofile);
        }
        return root;
    }
}