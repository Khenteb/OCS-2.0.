package com.example.ocs.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ocs.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText login_email, login_password;
    Button loginbtn;
    TextView register;
    ProgressBar progressBar;


    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progessBar);
        progressBar.setVisibility(View.GONE);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        loginbtn = findViewById(R.id.loginBtn);
        register = findViewById(R.id.link1);



        auth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(view ->{
            loginUser();
        });

        register.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        });

    }

    private void loginUser() {
        String email = login_email.getText().toString();
        String password = login_password.getText().toString();

        if(TextUtils.isEmpty(email)){
            login_email.setError("Email cannot be empty");
            login_email.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            login_password.setError("Password cannot be empty");
            login_password.requestFocus();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User registered", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Error" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}