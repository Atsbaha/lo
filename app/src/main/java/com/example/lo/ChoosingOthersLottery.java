package com.example.lo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class  ChoosingOthersLottery extends AppCompatActivity {

    Button btncheckTombola,btnCheckLyu1,btncheckEdl,btnCheckTinsaee,btnCheckLyu2,btnOthersCheckNext;
    CheckBox tombolaCheckBox,lyu1CheckBox,edlCheckBox,tinsaeeCheckBox,lyu2CheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_others_lottery);




        btncheckTombola=findViewById(R.id.btncheckTombola);
        btnCheckLyu1=findViewById(R.id.btnCheckLyu1);
        btncheckEdl=findViewById(R.id.btncheckEdl);
        btnCheckTinsaee=findViewById(R.id.btnCheckTinsaee);
        btnCheckLyu2=findViewById(R.id.btnCheckLyu2);
        btnOthersCheckNext=findViewById(R.id.btnOthersCheckNext);


        tombolaCheckBox=findViewById(R.id.tombolaCheckBox);
        lyu1CheckBox=findViewById(R.id.lyu1CheckBox);
        edlCheckBox=findViewById(R.id.edlCheckBox);
        tinsaeeCheckBox=findViewById(R.id.tinsaeeCheckBox);
        lyu2CheckBox=findViewById(R.id.lyu2CheckBox);


        btnOthersCheckNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tombolaCheckBox.isChecked() && !lyu1CheckBox.isChecked()
                        && ! edlCheckBox.isChecked() && !tinsaeeCheckBox.isChecked() && !lyu2CheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingOthersLottery.this,Payment.class);
                    startActivity(intent);
                }

                else  if(!tombolaCheckBox.isChecked() && lyu1CheckBox.isChecked()
                        && ! edlCheckBox.isChecked() && !tinsaeeCheckBox.isChecked() && !lyu2CheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingOthersLottery.this,Payment.class);
                    startActivity(intent);
                }

                else if(!tombolaCheckBox.isChecked() && !lyu1CheckBox.isChecked()
                        &&  edlCheckBox.isChecked() && !tinsaeeCheckBox.isChecked() && !lyu2CheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingOthersLottery.this,Payment.class);
                    startActivity(intent);
                }


                else if(!tombolaCheckBox.isChecked() && !lyu1CheckBox.isChecked()
                        &&   !edlCheckBox.isChecked() &&tinsaeeCheckBox.isChecked() && !lyu2CheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingOthersLottery.this,Payment.class);
                    startActivity(intent);
                }

                else if(!tombolaCheckBox.isChecked() && !lyu1CheckBox.isChecked()
                        &&   !edlCheckBox.isChecked() &&!tinsaeeCheckBox.isChecked() && lyu2CheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingOthersLottery.this,Payment.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ChoosingOthersLottery.this,"Check Single button only",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
