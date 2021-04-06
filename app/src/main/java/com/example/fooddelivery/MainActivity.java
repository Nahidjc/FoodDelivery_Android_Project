package com.example.fooddelivery;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.fooddelivery.model.Restaurant;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
     // SendDataToFireStore();
//        GetDataFromFirestore();

    }

//    private void GetDataFromFirestore() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("Restaurants")
//                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    for(DocumentSnapshot documentSnapshot:task.getResult()){
//                        Restaurant restaurant = documentSnapshot.toObject(Restaurant.class);
//                       // Log.e(TAG, "onComplete: "+restaurant.getRestaurantName());
//                        Log.i(TAG, "onComplete: "+restaurant.getRestaurantName());
//                    }
//                }
//            }
//        });
//    }

    private void SendDataToFireStore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference reference = db.collection("Restaurants");
        Restaurant myRestaurant = new Restaurant();
        myRestaurant.setRestaurantName("Nahid Restaurants");
        myRestaurant.setRestaurantDescription("Best Restaurant in Munshiganj");
        myRestaurant.setRestaurantLocation("Dhaka, Dhanmondi");
        myRestaurant.setRestaurantImgUrl("https://assets.indiabizforsale.com/business/upload_pic/food_1_35dcf69c0efb27682ec4d2e6b7697444.jpg");
        reference.add(myRestaurant).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Restaurant Uploaded", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Sorry not success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}