package com.dev0piyush.studentmanagment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.dev0piyush.studentmanagment.databinding.StudentSignUpBinding;
import com.dev0piyush.studentmanagment.sqlite.SqliteHelper;
import java.util.Objects;

public class SignUpStudent extends AppCompatActivity {
    private StudentSignUpBinding binding;
    private SqliteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=StudentSignUpBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        helper= new SqliteHelper(this);
        Objects.requireNonNull(binding.StudentFirstName.getText()).clear();
        Objects.requireNonNull(binding.StudentLastName.getText()).clear();
        Objects.requireNonNull(binding.StudentEmail.getText()).clear();
        Objects.requireNonNull(binding.StudentMobile.getText()).clear();
        Objects.requireNonNull(binding.StudentPassword.getText()).clear();
        SignUp();
        binding.ButtonAlreadyAccount.setOnClickListener(view1 -> startActivity(new Intent(getApplicationContext(), LoginStudent.class)));
    }

    private void SignUp(){
        String FName= Objects.requireNonNull(binding.StudentFirstName.getText()).toString();
        String LName= Objects.requireNonNull(binding.StudentLastName.getText()).toString();
        String Email= Objects.requireNonNull(binding.StudentEmail.getText()).toString();
        String Mobile= Objects.requireNonNull(binding.StudentMobile.getText()).toString();
        String Password= Objects.requireNonNull(binding.StudentPassword.getText()).toString();
        boolean CheckEmail= helper.CheckEmail(Email);
        binding.ButtonCreateAnAccount.setOnClickListener(view -> {
            if(!CheckEmail){
                boolean CreateUser=helper.InsertData(FName,LName,Email,Mobile,Password);
                if(CreateUser){
                    Toast.makeText(getApplicationContext(),"Sign Up SuccessFully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LoginStudent.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"You have already account",Toast.LENGTH_SHORT).show();
            }
        });
    }
}