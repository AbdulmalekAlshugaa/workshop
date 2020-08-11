package com.example.todofirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class createAccount extends AppCompatActivity {
    private EditText mEmailAddress, mPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //
        mAuth  = FirebaseAuth.getInstance();
        // xml
        mEmailAddress =findViewById(R.id.emailAddress);
        mPassword =findViewById(R.id.Password);
    }

    public void Login(View view) {
        Intent intent = new Intent(createAccount.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void CreateMain(View view) {
        String EmailAddress = mEmailAddress.getText().toString();
        String Password = mPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(EmailAddress, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(createAccount.this, "Created Successfully ", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(createAccount.this, "Error ", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}
