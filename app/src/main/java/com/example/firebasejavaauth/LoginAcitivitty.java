
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
        
        //call the function to find the IDS
        collectIds();
    }
    public void collectIdss()
    {
        TextView tvName = findViewById(R.id.name);
        TextView tvPass = findViewBy(R.id.pass);
    }
    public void ValidateUser()
    {
        //get the data 
        name = tvName.getString.trim();
        
        BtnLogin.
    }
}
