package com.dev0piyush.studentmanagment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev0piyush.studentmanagment.databinding.StudentLoginBinding;
import com.dev0piyush.studentmanagment.home.WelcomeUser;
import com.dev0piyush.studentmanagment.sqlite.SqliteHelper;

import java.util.Objects;

public class LoginStudent extends AppCompatActivity {
    private StudentLoginBinding binding;
    SqliteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=StudentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper=new SqliteHelper(this);
        Objects.requireNonNull(binding.StudentEmail.getText()).clear();
        Objects.requireNonNull(binding.StudentPassword.getText()).clear();
        SignIn();
    }
    private void SignIn(){
        String Email = Objects.requireNonNull(binding.StudentEmail.getText()).toString();
        String Password = Objects.requireNonNull(binding.StudentPassword.getText()).toString();

        binding.ButtonLogin.setOnClickListener(view -> {
            boolean CheckUserExist = helper.CheckEmailPassword(Email, Password);
            if (CheckUserExist) {
                startActivity(new Intent(getApplicationContext(), WelcomeUser.class));
                binding.StudentEmail.getText().clear();
                binding.StudentPassword.getText().clear();
            } else {
                Toast.makeText(getApplicationContext(), "User Not Exists", Toast.LENGTH_SHORT).show();
            }
        });
        binding.ButtonNewUser.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpStudent.class)));
    }
}