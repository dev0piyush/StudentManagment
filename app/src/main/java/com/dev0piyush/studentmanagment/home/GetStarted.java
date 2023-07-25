package com.dev0piyush.studentmanagment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.dev0piyush.studentmanagment.activities.SignUpStudent;
import com.dev0piyush.studentmanagment.databinding.GetStartedBinding;

public class GetStarted extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.dev0piyush.studentmanagment.databinding.GetStartedBinding binding = GetStartedBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.ButtonGetStarted.setOnClickListener(view1 -> startActivity(new Intent(getApplicationContext(), SignUpStudent.class)));
    }
}