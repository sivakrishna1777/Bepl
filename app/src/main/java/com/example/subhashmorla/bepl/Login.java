package com.example.subhashmorla.bepl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail,editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getting the information that user is already logged in or not
        //if user already logged in open main activity page

        firebaseauth= FirebaseAuth.getInstance();
        if(firebaseauth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }



        progressDialog= new ProgressDialog(this);
        buttonRegister=(Button)findViewById(R.id.regbtn);
        editTextEmail=(EditText)findViewById(R.id.email);
        editTextPassword=(EditText)findViewById(R.id.pword);
        textViewSignin=(TextView)findViewById(R.id.textview);
        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }
    private void registerUser(){
        String email=editTextEmail.getText().toString().trim();
        String password =editTextPassword.getText().toString().trim();

        //.trim() can remove leading and tailing whitespaces


        if(TextUtils.isEmpty(email)){
            //email is empty
            //text utils are used for operations on strings
            Toast.makeText(this, "Please Enter Email Id", Toast.LENGTH_SHORT).show();
            return;

        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        //registering new user

        firebaseauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //user is successfully registered and logged in

                    Toast.makeText(Login.this, "REGISTERED SUCCESSFULLY" , Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);}
                 else
                     Toast.makeText(Login.this, " NOT REGISTERED SUCCESSFULLY,Please try again.." , Toast.LENGTH_SHORT).show();


            }
        });
    }


    @Override
    public void onClick(View view) {
            if(view ==buttonRegister){
                registerUser();
            }
            if(view == textViewSignin){
                startActivity(new Intent(this,login2Activity.class));
            }
    }
}
