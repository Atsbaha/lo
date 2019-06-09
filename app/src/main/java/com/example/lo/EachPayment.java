package com.example.lo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EachPayment extends AppCompatActivity {


    Button first10,second10,third10,fourth10,eachNext;
    CheckBox firstCheck,secondCheck,thirdCheck,fourthCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_payment);



        first10=findViewById(R.id.first10);
        second10=findViewById(R.id.second10);
        third10=findViewById(R.id.third10);
        fourth10=findViewById(R.id.fourth10);
        eachNext=findViewById(R.id.eachNext);




        firstCheck=findViewById(R.id.firstCheck);
        secondCheck=findViewById(R.id.secondCheck);
        thirdCheck=findViewById(R.id.thirdCheck);
        fourthCheck=findViewById(R.id.fourthCheck);


        eachNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstCheck.isChecked() && secondCheck.isChecked() && thirdCheck.isChecked() && fourthCheck.isChecked()){
                    Intent intent=new Intent(EachPayment.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPayment.this,"40 Birr paymnet",Toast.LENGTH_LONG).show();
                }
                else if(firstCheck.isChecked() && secondCheck.isChecked() && thirdCheck.isChecked() && !fourthCheck.isChecked()){
                    Intent intent=new Intent(EachPayment.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPayment.this,"30 Birr paymnet",Toast.LENGTH_LONG).show();
                }

                else if(firstCheck.isChecked() && secondCheck.isChecked() && !thirdCheck.isChecked() && !fourthCheck.isChecked()){
                    Intent intent=new Intent(EachPayment.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPayment.this,"20 Birr paymnet",Toast.LENGTH_LONG).show();
                }

                else if(firstCheck.isChecked() && !secondCheck.isChecked() && !thirdCheck.isChecked() && !fourthCheck.isChecked()){
                    Intent intent=new Intent(EachPayment.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPayment.this,"10 Birr paymnet",Toast.LENGTH_LONG).show();
                }
                else  Toast.makeText(EachPayment.this,"Invalid Payment",Toast.LENGTH_LONG).show();
            }
        });
    }
}
