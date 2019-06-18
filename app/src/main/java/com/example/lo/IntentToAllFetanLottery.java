package com.example.lo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class IntentToAllFetanLottery extends AppCompatActivity {

    Button btnBingo,btnFetan,btnNational,btnHelp,btnFetanNext;
    CheckBox bingoCheckBox,NationalLotteryCheckBox,fetanCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_to_all_fetan_lottery);

        btnBingo=findViewById(R.id.btnBingo);
        btnFetan=findViewById(R.id.btnFetanLottery);
        btnNational=findViewById(R.id.btnNationalLottery);
        btnHelp=findViewById(R.id.btnhelp);
        btnFetanNext=findViewById(R.id.btnFetanNext);



        bingoCheckBox=findViewById(R.id.bingoCheckBox);
        NationalLotteryCheckBox=findViewById(R.id.NationalLotteryCheckBox);
        fetanCheckBox=findViewById(R.id.fetanCheckBox);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToAllFetanLottery.this,Help.class);
                startActivity(intent);
            }
        });







        btnFetanNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bingoCheckBox.isChecked() && !NationalLotteryCheckBox.isChecked() && !fetanCheckBox.isChecked()){
                    Intent intent=new Intent(IntentToAllFetanLottery.this,BingoLottery.class);
                startActivity(intent);
                }

               else if(!bingoCheckBox.isChecked() && NationalLotteryCheckBox.isChecked() && !fetanCheckBox.isChecked()){
                    Intent intent=new Intent(IntentToAllFetanLottery.this,NationalLottery.class);
                startActivity(intent);
                }

                else if(!bingoCheckBox.isChecked() && !NationalLotteryCheckBox.isChecked() && fetanCheckBox.isChecked()){
                    Intent intent=new Intent(IntentToAllFetanLottery.this,InstantLottery.class);
                 startActivity(intent);
                }

                else{
                    Toast.makeText(IntentToAllFetanLottery.this,"Check Single button only",Toast.LENGTH_LONG).show();
                }
            }
        });
//        btnBingo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(IntentToAllFetanLottery.this,BingoLottery.class);
//                startActivity(intent);
//            }
//        });
//
//        btnFetan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(IntentToAllFetanLottery.this,InstantLottery.class);
//                startActivity(intent);
//            }
//        });
//
//
//        btnNational.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(IntentToAllFetanLottery.this,NationalLottery.class);
//                startActivity(intent);
//            }
//        });
    }
}
