package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class SignUp extends AppCompatActivity {
    EditText name, email, pass;
    Button signup;
    TextView signin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        signup = findViewById(R.id.sign_up_btn);
        signin = findViewById(R.id.Login_link);
        db = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            //when the user already has an account
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogIn.class));
            }
        });

        //when the user click the sign up button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String userpass = pass.getText().toString();

        //display error message when the user does not fill the email or the password
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(useremail) || TextUtils.isEmpty(userpass)) {
                    Toast.makeText(SignUp.this, "Please Fill All The Fileds!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (userpass.length() < 8) {
                    Toast.makeText(SignUp.this, "The Password is too short, please enter at least 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

      //check the user info from the database
                if (!db.checkUser(useremail)){
                    boolean insert = db.insertUser(username, useremail, userpass);
                    if (insert){
                        Toast.makeText(SignUp.this,"You Have Signed Up Successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),LogIn.class));
                    }else
                        Toast.makeText(SignUp.this,"Something is wrong, please try again! ", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUp.this,"This user is already has an account!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}