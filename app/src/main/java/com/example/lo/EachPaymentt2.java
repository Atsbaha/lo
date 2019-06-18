package com.example.lo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class EachPaymentt2 extends AppCompatActivity {


    Button first1010,second1010,third1010,fourth1010,eachNext10;
    CheckBox firstCheck10,secondCheck10,thirdCheck10,fourhtCheck10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_payment);



        first1010=findViewById(R.id.first1010);
        second1010=findViewById(R.id.second1010);
        third1010=findViewById(R.id.third1010);
        fourth1010=findViewById(R.id.fourth1010);
        eachNext10=findViewById(R.id.eachNext10);




        firstCheck10=findViewById(R.id.firstCheck10);
        secondCheck10=findViewById(R.id.secondCheck10);
        thirdCheck10=findViewById(R.id.thirdCheck10);
        fourhtCheck10=findViewById(R.id.fourthCheck10);


        eachNext10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstCheck10.isChecked() && secondCheck10.isChecked() && thirdCheck10.isChecked() && fourhtCheck10.isChecked()){
                    Intent intent=new Intent(EachPaymentt2.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPaymentt2.this,"40 Birr paymnet",Toast.LENGTH_LONG).show();
                }
                else if(firstCheck10.isChecked() && secondCheck10.isChecked() && thirdCheck10.isChecked() && !fourhtCheck10.isChecked()){
                    Intent intent=new Intent(EachPaymentt2.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPaymentt2.this,"30 Birr paymnet",Toast.LENGTH_LONG).show();
                }

                else if(firstCheck10.isChecked() && secondCheck10.isChecked() && !thirdCheck10.isChecked() && !fourhtCheck10.isChecked()){
                    Intent intent=new Intent(EachPaymentt2.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPaymentt2.this,"20 Birr paymnet",Toast.LENGTH_LONG).show();
                }

                else if(firstCheck10.isChecked() && !secondCheck10.isChecked() && !thirdCheck10.isChecked() && !fourhtCheck10.isChecked()){
                    Intent intent=new Intent(EachPaymentt2.this,Payment.class);
                    startActivity(intent);

                    Toast.makeText(EachPaymentt2.this,"10 Birr paymnet",Toast.LENGTH_LONG).show();
                }
                else  Toast.makeText(EachPaymentt2.this,"Invalid Payment",Toast.LENGTH_LONG).show();
            }
        });
    }
}
