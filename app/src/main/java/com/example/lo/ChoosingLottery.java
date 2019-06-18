package com.example.lo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ChoosingLottery extends AppCompatActivity {

    Button btncheckZhon,btnCheckEnkutatash,btncheckGena,btnCheckFetan,btnCheckOthers,btnCheckNext;
    CheckBox zhonCheckBox,enkutatashCheckBox,genaCheckBox,fetanCheckBox,othersCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_lottery);




        btncheckZhon=findViewById(R.id.btncheckZhon);
        btnCheckEnkutatash=findViewById(R.id.btnCheckEnkutatash);
        btncheckGena=findViewById(R.id.btncheckGena);
        btnCheckFetan=findViewById(R.id.btnCheckFetan);
        btnCheckOthers=findViewById(R.id.btnCheckOthers);
        btnCheckNext=findViewById(R.id.btnCheckNext);


        zhonCheckBox=findViewById(R.id.zhonCheckBox);
        enkutatashCheckBox=findViewById(R.id.enkutatashCheckBox);
        genaCheckBox=findViewById(R.id.genaCheckBox);
        fetanCheckBox=findViewById(R.id.fetanCheckBox);
        othersCheckBox=findViewById(R.id.othersCheckBox);


        btnCheckNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zhonCheckBox.isChecked() && !enkutatashCheckBox.isChecked()
                        && !genaCheckBox.isChecked() && !fetanCheckBox.isChecked() && !othersCheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingLottery.this,ZhonLottery.class);

                    startActivity(intent);

//                    String zhon="zhon";
//                    intent.putExtra(zhon,"zhon");
//

                }

                else if(!zhonCheckBox.isChecked() && enkutatashCheckBox.isChecked()
                        && !genaCheckBox.isChecked() && !fetanCheckBox.isChecked() && !othersCheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingLottery.this,EnkutatashLottery.class);
                    startActivity(intent);


//                    String enkutatash="enkutatash";
//                    intent.putExtra(enkutatash,"enkutatash");
//
                }

                else if(!zhonCheckBox.isChecked() && !enkutatashCheckBox.isChecked()
                        && genaCheckBox.isChecked() && !fetanCheckBox.isChecked() && !othersCheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingLottery.this,GenaLottery.class);
                    startActivity(intent);
                }


                else if(!zhonCheckBox.isChecked() && !enkutatashCheckBox.isChecked()
                        && !genaCheckBox.isChecked() && fetanCheckBox.isChecked() && !othersCheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingLottery.this,IntentToAllFetanLottery.class);
                    startActivity(intent);
                }

                else if(!zhonCheckBox.isChecked() && !enkutatashCheckBox.isChecked()
                        && !genaCheckBox.isChecked() && !fetanCheckBox.isChecked() && othersCheckBox.isChecked()){
                    Intent intent=new Intent(ChoosingLottery.this,ChoosingOthersLottery.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ChoosingLottery.this,"Check Single button only",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
