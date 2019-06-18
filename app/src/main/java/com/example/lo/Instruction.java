package com.example.lo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Instruction extends AppCompatActivity {

    Button btnInstant,btnBingo, btnZhon,btnEnkutatash,btnLyu1,btnLyu2,btnEdl,btnTombola,btnTinsaee;
    int visibility=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        btnInstant=findViewById(R.id.ፈጣን);
        btnBingo=findViewById(R.id.ቢንጎ);


        btnZhon=findViewById(R.id.ዝሆን);

        btnEnkutatash=findViewById(R.id.እንቁጣጣሽ);

        btnLyu1=findViewById(R.id.ልዩአንድ);
        btnLyu2=findViewById(R.id.ልዩሁለት);

        btnEdl=findViewById(R.id.ዕድል);
        btnTombola=findViewById(R.id.ቶምቦላ);
        btnTinsaee=findViewById(R.id.ትንሣኤ);




        btnTombola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tombola();
            }
        });



        btnEdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edl();
            }
        });


        btnInstant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instant();

            }
        });




        btnZhon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhone();
            }
        });


        btnEnkutatash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enkutatash();
            }
        });



        btnLyu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyuand();
            }
        });


        btnLyu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyuhulet();
            }
        });


    }

    private void tombola() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.tombolalayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();

    }

    private void edl() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.edllayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();
    }

    private void lyuhulet() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.lyuhuletlayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();
    }

    private void lyuand() {



        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.lyuandlayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();
    }


    private void enkutatash() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.enkutatashlayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();




    }

    private void zhone() {


        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.zhonlayout,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();
    }

    private void Instant() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Instruction.this);
        alertDialog.setTitle("Urgent information ");
        alertDialog.setMessage("All informations that winners will be given are available below \nIn Order to play the game freely\n" +
                "The more frequent Numbers hold more money");

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.instant,null);

//        final EditText edtPassword=view.findViewById(R.id.edtPassword);
//        final EditText edtNewPassword=view.findViewById(R.id.edtNewPassword);
//        final EditText edtRepeatPassword=view.findViewById(R.id.edtRepeatPassword);

        final ImageView imageView=view.findViewById(R.id.imgInstant);

        alertDialog.setView(view);
        alertDialog.show();

    }
}
