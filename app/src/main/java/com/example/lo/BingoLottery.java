package com.example.lo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class BingoLottery extends AppCompatActivity {

    private Button[][] bingoButtons1=new Button[5][5];
    private Button[][] bingoButtons2=new Button[5][5];
    private Button[][] bingoButtons3=new Button[5][5];
    private Button[][] bingoButtons4=new Button[5][5];
    Button B,I,N,G,O,generateAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_lottery);

        B=findViewById(R.id.button_b);
        I=findViewById(R.id.button_I);
        N=findViewById(R.id.button_N);
        G=findViewById(R.id.button_G);
        O=findViewById(R.id.button_o);

        generateAll=findViewById(R.id.generateAll);


        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                String buttonID="button_b" +i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                bingoButtons1[i][j]=findViewById(resID);
                bingoButtons1[i][j].setEnabled(false);



                String button2ID="button_bb" +i+j;
                int res2ID=getResources().getIdentifier(button2ID,"id",getPackageName());
                bingoButtons2[i][j]=findViewById(res2ID);
                bingoButtons2[i][j].setEnabled(false);


                String button3ID="button_bbb" +i+j;
                int res3ID=getResources().getIdentifier(button3ID,"id",getPackageName());
                bingoButtons3[i][j]=findViewById(res3ID);
                bingoButtons3[i][j].setEnabled(false);

                String button4ID="button_c" +i+j;
                int res4ID=getResources().getIdentifier(button4ID,"id",getPackageName());
                bingoButtons4[i][j]=findViewById(res4ID);
                bingoButtons4[i][j].setEnabled(false);


            }
        }


        generateAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generzteFirst();
                generateSecond();
                genertaeThird();
                generateFourth();
            }
        });

    }

    private void generateFourth() {

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {

                final String characters="BINGO";
                StringBuilder result=new StringBuilder();

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

                result.append(characters.charAt(rand.nextInt(characters.length())));


//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text


                bingoButtons4[i][j].setText(result.toString()+myString);



            }
        }

    }

    private void genertaeThird() {

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text

                bingoButtons3[i][j].setText(myString);

            }
        }


    }

    private void generateSecond() {

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text


                bingoButtons2[i][j].setText(myString);


            }
        }

    }

    public void generzteFirst() {


        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text


                bingoButtons1[i][j].setText(myString);




            }
        }




    }
}
