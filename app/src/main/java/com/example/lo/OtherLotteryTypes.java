package com.example.lo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OtherLotteryTypes extends AppCompatActivity {


    Button btnTombola,btnLyu1,btnlyu2,btnEdl,btnTnsaae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_lottery_types);




        btnTombola=findViewById(R.id.btnTombola);
        btnLyu1=findViewById(R.id.btnLyu1);
        btnlyu2=findViewById(R.id.btnLyu2);
        btnTnsaae=findViewById(R.id.btnTnsae);
        btnEdl=findViewById(R.id.btnEdl);



        btnTombola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherLotteryTypes.this,TombolaLottery.class);
                startActivity(intent);
            }
        });



        btnLyu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherLotteryTypes.this,Lyu1Lottery.class);
                startActivity(intent);
            }
        });


        btnlyu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherLotteryTypes.this,Lyu2Lottery.class);
                startActivity(intent);
            }
        });

        btnTnsaae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherLotteryTypes.this,TinsaeeLottery.class);
                startActivity(intent);
            }
        });

        btnEdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherLotteryTypes.this,EdlLottery.class);
                startActivity(intent);
            }
        });
    }
}
