package com.example.lo;


        import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentToLotteryTypes extends AppCompatActivity {
    Button btnZhon,btnEnkutatash,btnFetan,btnGena,btnOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_to_lottery_types);

        btnZhon=findViewById(R.id.btnZhon);
        btnEnkutatash=findViewById(R.id.btnEnkutatsh);
        btnFetan=findViewById(R.id.btnFetan);
//        btnAbay=findViewById(R.id.btnAbay);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/TIMES.TTF");
        btnZhon.setTypeface(typeface);
        btnEnkutatash.setTypeface(typeface);
        btnFetan.setTypeface(typeface);
//        btnAbay.setTypeface(typeface);
        btnOthers=findViewById(R.id.btnOthers);

        btnOthers.setTypeface(typeface);


        btnGena=findViewById(R.id.btnGena);

        btnGena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToLotteryTypes.this,GenaLottery.class);
                startActivity(intent);
            }
        });



        btnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToLotteryTypes.this,OtherLotteryTypes.class);
                startActivity(intent);
            }
        });




//      //  btnTableReservation=findViewById(R.id.btnTableReservation);a



        btnZhon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToLotteryTypes.this,ZhonLottery.class);
                startActivity(intent);
            }
        });
       btnEnkutatash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(IntentToLotteryTypes.this,EnkutatashLottery.class);
                startActivity(intent);
            }
        });
        btnFetan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToLotteryTypes.this,IntentToAllFetanLottery.class);
                startActivity(intent);
            }
        });
        /*btnAbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntentToLotteryTypes.this,AbayLottery.class);
                startActivity(intent);
            }
        });*/

    }
}

