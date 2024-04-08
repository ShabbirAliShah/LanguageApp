package com.example.languageapp.Activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.languageapp.Fragments.AvailableCourses;
import com.example.languageapp.R;
import com.example.languageapp.databinding.ActivityLanguageBinding;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @NonNull
        ActivityLanguageBinding binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btnHome = findViewById(R.id.btnHome);

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.langfrag, new AvailableCourses())
                            .commit();
            }
    }