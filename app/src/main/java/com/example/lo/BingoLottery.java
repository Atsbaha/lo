package com.example.lo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lo.viewModels.BingoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class BingoLottery extends AppCompatActivity {

    DatabaseReference databaseReference;

    private Button[][] bingoButtons1=new Button[5][5];
    private Button[][] bingoButtons2=new Button[5][5];
    private Button[][] bingoButtons3=new Button[5][5];
    private Button[][] bingoButtons4=new Button[5][5];
    Button B,I,N,G,O,generateAll,btnUniqueNumber;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_lottery);

        B=findViewById(R.id.button_b);
        I=findViewById(R.id.button_I);
        N=findViewById(R.id.button_N);
        G=findViewById(R.id.button_G);
        O=findViewById(R.id.button_o);

        btnUniqueNumber=findViewById(R.id.btnBingoUniqueNumber);
        edtEmail=findViewById(R.id.edtBingoEmail);


        generateAll=findViewById(R.id.generateAll);


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Bingo Lottery");


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


      /*  generateAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generzteFirst();
                generateSecond();
                genertaeThird();
                generateFourth();
                GetUniqueNumber(10);
            }
        });*/


      generateAll.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              databaseReference=FirebaseDatabase.getInstance().getReference().child("Bingo Lottery");
//              String Email=edtEmail.getText().toString();

//              if(!Email.isEmpty()){


              generzteFirst();
              generateSecond();
              genertaeThird();
              generateFourth();
              GetUniqueNumber(10);
//              databaseReference=FirebaseDatabase.getInstance().getReference().child("Bingo Lottery");
                  databaseReference.addValueEventListener(new ValueEventListener() {
                      @Override
                      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                      String btnNumber=dataSnapshot.child("uniqueNumber").getValue().toString();
//                      btnUniqueNumber.setText(btnNumber);

                      }

                      @Override
                      public void onCancelled(@NonNull DatabaseError databaseError) {

                      }
                  });

//              }
//              else
//                  Toast.makeText(BingoLottery.this, "Enter Email First", Toast.LENGTH_SHORT).show();


          }
      });

    }

    private static String GetUniqueNumber(int i) {
        String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result=new StringBuilder();
        while (i>0){
            Random random=new Random();
            result.append(characters.charAt(random.nextInt(characters.length())));
            i--;

        }
        return result.toString();



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
                String Email=edtEmail.getText().toString();







                generateFourth();
//                        String x=B.getText().toString() + bingoButtons1[0][0].getText().toString();
                String B="B"+bingoButtons1[0][0].getText().toString();
                String I="I"+bingoButtons1[0][1].getText().toString();
                String N="N"+bingoButtons1[0][2].getText().toString();
                String G="G"+bingoButtons1[0][3].getText().toString();
                String O="O"+bingoButtons1[0][4].getText().toString();



                String BB="B"+bingoButtons1[1][0].getText().toString();
                String II="I"+bingoButtons1[1][1].getText().toString();
                String NN="N"+bingoButtons1[1][2].getText().toString();
                String GG="G"+bingoButtons1[1][3].getText().toString();
                String OO="O"+bingoButtons1[1][4].getText().toString();



                String BBB="B"+bingoButtons1[2][0].getText().toString();
                String III="I"+bingoButtons1[2][1].getText().toString();
                String NNN="N"+bingoButtons1[2][2].getText().toString();
                String GGG="G"+bingoButtons1[2][3].getText().toString();
                String OOO="O"+bingoButtons1[2][4].getText().toString();


                String BBBB="B"+bingoButtons1[3][0].getText().toString();
                String IIII="I"+bingoButtons1[3][1].getText().toString();
                String NNNN="N"+bingoButtons1[3][2].getText().toString();
                String GGGG="G"+bingoButtons1[3][3].getText().toString();
                String OOOO="O"+bingoButtons1[3][4].getText().toString();



                String BBBBB="B"+bingoButtons1[4][0].getText().toString();
                String IIIII="I"+bingoButtons1[4][1].getText().toString();
                String NNNNN="N"+bingoButtons1[4][2].getText().toString();
                String GGGGG="G"+bingoButtons1[4][3].getText().toString();
                String OOOOO="O"+bingoButtons1[4][4].getText().toString();





                String I10="I"+bingoButtons1[1][0].getText().toString();
                String G14="G"+bingoButtons1[1][4].getText().toString();
                String I20="N"+bingoButtons1[2][0].getText().toString();
                String G24="N"+bingoButtons1[2][4].getText().toString();
                String I30="G"+bingoButtons1[3][0].getText().toString();
                String I34="I"+bingoButtons1[3][0].getText().toString();



                String O40="O"+bingoButtons1[4][0].getText().toString();
                String G41="G"+bingoButtons1[4][1].getText().toString();
                String N42="N"+bingoButtons1[4][2].getText().toString();
                String I43="I"+bingoButtons1[4][3].getText().toString();
                String B44="B"+bingoButtons1[4][4].getText().toString();





                     //NKULU ROW AND COLUMN

                if(
                           B.equals(bingoButtons4[i][j].getText().toString())
                        && I.equals(bingoButtons4[i][j].getText().toString())
                        && N.equals(bingoButtons4[i][j].getText().toString())
                        && G.equals(bingoButtons4[i][j].getText().toString())
                        && O.equals(bingoButtons4[i][j].getText().toString())


                        && BB.equals(bingoButtons4[i][j].getText().toString())
                        && II.equals(bingoButtons4[i][j].getText().toString())
                        && NN.equals(bingoButtons4[i][j].getText().toString())
                        && GG.equals(bingoButtons4[i][j].getText().toString())
                        && OO.equals(bingoButtons4[i][j].getText().toString())


                         && BBB.equals(bingoButtons4[i][j].getText().toString())
                         && III.equals(bingoButtons4[i][j].getText().toString())
                          && NNN.equals(bingoButtons4[i][j].getText().toString())
                          && GGG.equals(bingoButtons4[i][j].getText().toString())
                          && OOO.equals(bingoButtons4[i][j].getText().toString())


                          && BBBB.equals(bingoButtons4[i][j].getText().toString())
                          && IIII.equals(bingoButtons4[i][j].getText().toString())
                          && NNNN.equals(bingoButtons4[i][j].getText().toString())
                          && GGGG.equals(bingoButtons4[i][j].getText().toString())
                          && OOOO.equals(bingoButtons4[i][j].getText().toString())


                           && BBBBB.equals(bingoButtons4[i][j].getText().toString())
                           && IIIII.equals(bingoButtons4[i][j].getText().toString())
                           && NNNNN.equals(bingoButtons4[i][j].getText().toString())
                           && GGGGG.equals(bingoButtons4[i][j].getText().toString())
                           && OOOOO.equals(bingoButtons4[i][j].getText().toString())){
                    Toast.makeText(BingoLottery.this,"150,000 birr prise",Toast.LENGTH_SHORT).show();

//                    public BingoModel(String emaill, String birrAmount,String uniqueNumber)
                    BingoModel zhonModel = new BingoModel(Email,"150,000 birr",GetUniqueNumber(10));
                    databaseReference.setValue(zhonModel);
                }



                //NETI ZURYA

                else if(B.equals(bingoButtons4[i][j].getText().toString())
                        && I.equals(bingoButtons4[i][j].getText().toString())
                        && N.equals(bingoButtons4[i][j].getText().toString())
                        && G.equals(bingoButtons4[i][j].getText().toString())
                        && O.equals(bingoButtons4[i][j].getText().toString())


                    && I10.equals(bingoButtons4[i][j].getText().toString())
                    && G14.equals(bingoButtons4[i][j].getText().toString())
                    && I20.equals(bingoButtons4[i][j].getText().toString())
                    && G24.equals(bingoButtons4[i][j].getText().toString())
                    && I30.equals(bingoButtons4[i][j].getText().toString())
                    && I34.equals(bingoButtons4[i][j].getText().toString())



                   && O40.equals(bingoButtons4[i][j].getText().toString())
                    && G41.equals(bingoButtons4[i][j].getText().toString())
                    && N42.equals(bingoButtons4[i][j].getText().toString())
                    && I43.equals(bingoButtons4[i][j].getText().toString())
                    && B44.equals(bingoButtons4[i][j].getText().toString())){
                    Toast.makeText(BingoLottery.this,"150,000 birr prise",Toast.LENGTH_SHORT).show();

//                    public BingoModel(String emaill, String birrAmount,String uniqueNumber)
                    BingoModel zhonModel = new BingoModel(Email,"75,000 birr",GetUniqueNumber(10));
                    databaseReference.setValue(zhonModel);


                }

                else if(B.equals(bingoButtons4[i][j].getText().toString())
                       && II.equals(bingoButtons4[i][j].getText().toString())
                       && NNN.equals(bingoButtons4[i][j].getText().toString())
                       && GGGG.equals(bingoButtons4[i][j].getText().toString())
                       && OOOOO.equals(bingoButtons4[i][j].getText().toString())


                        && BBBBB.equals(bingoButtons4[i][j].getText().toString())
                        && IIII.equals(bingoButtons4[i][j].getText().toString())
                        && NNN.equals(bingoButtons4[i][j].getText().toString())
                        && GG.equals(bingoButtons4[i][j].getText().toString())
                        && O.equals(bingoButtons4[i][j].getText().toString())){
                    Toast.makeText(BingoLottery.this,"25,000 birr prise",Toast.LENGTH_SHORT).show();

//                    public BingoModel(String emaill, String birrAmount,String uniqueNumber)
                    BingoModel zhonModel = new BingoModel(Email,"25,000 birr",GetUniqueNumber(10));
                    databaseReference.setValue(zhonModel);

                }

                else if(
                        B.equals(bingoButtons4[i][j].getText().toString())
                                && I.equals(bingoButtons4[i][j].getText().toString())
                                && N.equals(bingoButtons4[i][j].getText().toString())
                                && G.equals(bingoButtons4[i][j].getText().toString())
                                && O.equals(bingoButtons4[i][j].getText().toString())


                                && BB.equals(bingoButtons4[i][j].getText().toString())
                                && II.equals(bingoButtons4[i][j].getText().toString())
                                && NN.equals(bingoButtons4[i][j].getText().toString())
                                && GG.equals(bingoButtons4[i][j].getText().toString())
                                && OO.equals(bingoButtons4[i][j].getText().toString())


                                && BBB.equals(bingoButtons4[i][j].getText().toString())
                                && III.equals(bingoButtons4[i][j].getText().toString())
                                && NNN.equals(bingoButtons4[i][j].getText().toString())
                                && GGG.equals(bingoButtons4[i][j].getText().toString())
                                && OOO.equals(bingoButtons4[i][j].getText().toString())


                                && BBBB.equals(bingoButtons4[i][j].getText().toString())
                                && IIII.equals(bingoButtons4[i][j].getText().toString())
                                && NNNN.equals(bingoButtons4[i][j].getText().toString())
                                && GGGG.equals(bingoButtons4[i][j].getText().toString())
                                && OOOO.equals(bingoButtons4[i][j].getText().toString())){
                    Toast.makeText(BingoLottery.this,"10,000 birr prise",Toast.LENGTH_SHORT).show();

//                    public BingoModel(String emaill, String birrAmount,String uniqueNumber)
                    BingoModel zhonModel = new BingoModel(Email,"10,000 birr",GetUniqueNumber(10));
                    databaseReference.setValue(zhonModel);
                }
                else if(
                        B.equals(bingoButtons4[i][j].getText().toString())
                                && I.equals(bingoButtons4[i][j].getText().toString())
                                && N.equals(bingoButtons4[i][j].getText().toString())
                                && G.equals(bingoButtons4[i][j].getText().toString())
                                && O.equals(bingoButtons4[i][j].getText().toString())




                                && BBB.equals(bingoButtons4[i][j].getText().toString())
                                && III.equals(bingoButtons4[i][j].getText().toString())
                                && NNN.equals(bingoButtons4[i][j].getText().toString())
                                && GGG.equals(bingoButtons4[i][j].getText().toString())
                                && OOO.equals(bingoButtons4[i][j].getText().toString())){
                    Toast.makeText(BingoLottery.this,"5,000 birr prise",Toast.LENGTH_SHORT).show();

//                    public BingoModel(String emaill, String birrAmount,String uniqueNumber)
                    BingoModel zhonModel = new BingoModel(Email,"5,000 birr",GetUniqueNumber(10));
                    databaseReference.setValue(zhonModel);
                }




            }
        }




    }
}
