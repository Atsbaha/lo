package com.example.lo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentToAllFetanLottery extends AppCompatActivity {

    Button btnBingo,btnFetan,btnNational;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_to_all_fetan_lottery);

        btnBingo=findViewById(R.id.btnBingo);
        btnFetan=findViewById(R.id.btnFetanLottery);
        btnNational=findViewById(R.id.btnNationalLottery);



        btnBingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToAllFetanLottery.this,BingoLottery.class);
                startActivity(intent);
            }
        });

        btnFetan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToAllFetanLottery.this,InstantLottery.class);
                startActivity(intent);
            }
        });


        btnNational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToAllFetanLottery.this,NationalLottery.class);
                startActivity(intent);
            }
        });
    }
}
