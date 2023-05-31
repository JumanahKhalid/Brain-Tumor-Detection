package com.example.app;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.DBHelper;

public class LogIn extends AppCompatActivity {

    EditText userEmail, password;
    Button signin;
    TextView signup;
    DBHelper db;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userEmail = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        signin = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup_link);
        db = new DBHelper(this);

       // start the session to display the name of the user
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

       //open sign-up activity when the user click "sign_up"
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });

      // open log-in activity when the user click "log-in" button
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmail.getText().toString();
                String pass = password.getText().toString();

                //display error message when the user does not fill the email or the password
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LogIn.this,"Email Is Required!",Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(LogIn.this,"Password Is Required!",Toast.LENGTH_SHORT).show();
                    return;
                }

                // check the user info from the database
                boolean checkUser = db.checkUser(email);
                boolean checkInfo = db.checkUserInfo(email,pass);

                if (checkUser == false) {
                    Toast.makeText(LogIn.this, "The Email is not found, Please Sign Up", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (checkInfo == false) {
                    Toast.makeText(LogIn.this, "The Email and Password Are Not Matches!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //if everything went well, save the user email and name in the session (after retrieve the name from the database)
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_EMAIL, email);
                editor.putString(KEY_NAME, db.getName(email));
                editor.apply();

                //after user log in Successfully, open "Home" activity!
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });
    }
}