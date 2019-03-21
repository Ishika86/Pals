package com.isha.pals;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterStudentActivity extends AppCompatActivity
{
    EditText email,password;
    FirebaseAuth firebaseAuth;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btn_register=(Button)findViewById(R.id.btn_register);

        firebaseAuth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String input_email=email.getText().toString();
                final String input_password=password.getText().toString();

                if(TextUtils.isEmpty(input_email))
                    Toast.makeText(getApplicationContext(),"Please enter email address",Toast.LENGTH_LONG).show();;
                if(TextUtils.isEmpty(input_password))
                    Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();

                firebaseAuth.createUserWithEmailAndPassword(input_email,input_password).addOnCompleteListener(RegisterStudentActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(RegisterStudentActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Not registered",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}
