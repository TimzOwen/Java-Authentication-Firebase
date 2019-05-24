package com.example.firebasejavaauth;

import android.app.ProgressDialog;
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

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button btnRegister;
    private EditText etUName, etUPass;
    private TextView tvAlreadyRegistered;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize progress bar

        progressDialog = new ProgressDialog(this);
      //initialize firebase
        firebaseAuth = FirebaseAuth.getInstance();


        btnRegister = (Button) findViewById(R.id.btnLlogin);
        etUName = (EditText)findViewById(R.id.etUSerEmail);
        etUPass = (EditText)findViewById(R.id.etUSerPassword);
        tvAlreadyRegistered = (TextView) findViewById(R.id.tvAlready_Registered);

        btnRegister.setOnClickListener(this);
        tvAlreadyRegistered.setOnClickListener(this);

    }

    private void registerUSer()
    {
        String email = etUName.getText().toString().trim();
        String password = etUPass.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_LONG).show();

            return;

        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_LONG).show();
            return;

        }

        progressDialog.setMessage("Registering, please Wait.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss;
                            Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Could not Register try Again", Toast.LENGTH_LONG).show();

                        }

                    }
                });


    }

    @Override
    public void onClick(View v)
    {
        if (v==btnRegister)
        {
            registerUSer();
        }
        if (v== tvAlreadyRegistered)
        {
            //login user page
        }

    }
}
