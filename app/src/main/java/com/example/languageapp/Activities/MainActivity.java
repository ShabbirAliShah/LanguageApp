package com.example.languageapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.languageapp.Fragments.EnrolledCourseFragment;
import com.example.languageapp.Fragments.HomeFragment;
import com.example.languageapp.Fragments.WishListFragment;
import com.example.languageapp.R;
import com.example.languageapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button logout , langlst;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        @NonNull
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Button btnHome = findViewById(R.id.btnHome);
        Button btnWishList = findViewById(R.id.btnWishList);
        Button btnEnrolledCourses = findViewById(R.id.btnEnrolledCourses);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new HomeFragment())
                        .commit();
            }
        });

        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new WishListFragment())
                        .commit();
            }
        });

        btnEnrolledCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new EnrolledCourseFragment())
                        .commit();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        langlst = findViewById(R.id.langlst);
        textView = findViewById(R.id.userDetail);
        user = mAuth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            textView.setText(user.getEmail());
        }

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        });

        langlst.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LanguageActivity.class);
            startActivity(intent);
            finish();
        });

    }
}