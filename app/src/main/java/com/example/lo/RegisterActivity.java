package com.example.lo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_email_field,reg_pass_field,reg_confirm_pass_field;
    private Button reg_btn,reg_login_btn;
//    private ProgressBar reg_progress;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        reg_email_field=findViewById(R.id.reg_email);
        reg_pass_field=findViewById(R.id.reg_password);
        reg_confirm_pass_field=findViewById(R.id.reg_confirm_password);

        reg_btn=findViewById(R.id.reg_btn);
        reg_login_btn=findViewById(R.id.reg_login_btn);

//        reg_progress=findViewById(R.id.reg_progress);


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=reg_email_field.getText().toString();
                String password=reg_pass_field.getText().toString();
                String confirm_password=reg_confirm_pass_field.getText().toString();


                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirm_password))
                {
                    if(password.equals(confirm_password))
                    {
//                        reg_progress.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            //if we login successfully go to activity you want
                            if(task.isSuccessful())
                            {
                                //write an activity here you want to go but for the time being let us use toast message

//                                sendToMain();

                                Toast.makeText(RegisterActivity.this,"successfull",Toast.LENGTH_LONG).show();
                            }else{
                                String errorMessage=task.getException().getMessage();
                                Toast.makeText(RegisterActivity.this,"error :"+errorMessage,Toast.LENGTH_LONG).show();
                            }

//                            reg_progress.setVisibility(View.VISIBLE);//after successfull login
                        }






                    });
                    }else{
                        Toast.makeText(RegisterActivity.this,"password does not match",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }

    /*@Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser=mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            sendToMain();
        }
    }

    private void sendToMain() {
        Intent mainIntent=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }*/
}
