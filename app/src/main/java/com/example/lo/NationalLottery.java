package com.example.lo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lo.viewModels.NationalLotteryModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class NationalLottery extends AppCompatActivity {
    DatabaseReference databaseReference;
    int counter=0;
    int counter2=0;
    int counter3=0;
    int counter4=0;
    int counter5=0,counter6=0,counter7=0,counter8=0,counter9=0,counter10=0,counter11=0;
    int counter12=0,counter13=0,counter14=0,counter15=0,counter16=0,counter17=0;


    private Button[][] buttons=new Button[4][4];
    Button getTicketNumber,tryAnotherNumber;
    TextView txtNumberShowing;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_lottery);


        getTicketNumber=findViewById(R.id.getNationalLotteryTicketNumber);
        tryAnotherNumber=findViewById(R.id.tryAnotherNumber);
//        txtNumberShowing=findViewById(R.id.nationalLotterytextView);
        edtEmail=findViewById(R.id.EnterNationalLotterEmail);





        getTicketNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTicketNumber();
                getTicketNumber.setEnabled(false);

//                Intent intent=new Intent(NationalLottery.this,Payment.class);
//                startActivity(intent);


                String NationalLotteryEmail=edtEmail.getText().toString();




            }
        });

        databaseReference= FirebaseDatabase.getInstance().getReference().child("National Lottery");



        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                String buttonID="button_" +i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);

            }
        }


    }


    public void showTicketNumber() {

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(9);

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
                buttons[i][j].setText(myString);



            }
            String NationalLotteryEmail=edtEmail.getText().toString();


            for (int m = 0; m < 4; m++) {


                String y,l;
                y=  (String) buttons[0][0].getText().toString();
                l= (String) buttons[i][m].getText().toString();
                if (y.equals(l))


                    counter2++;

                if(buttons[0][1].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter3++;

                if(buttons[0][2].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter4++;
                if(buttons[0][3].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter5++;




                if(buttons[1][0].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter6++;
                if(buttons[1][1].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter7++;
                if(buttons[1][2].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter8++;
                if(buttons[1][3].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter9++;


                if(buttons[2][0].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter10++;
                if(buttons[2][1].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter11++;
                if(buttons[2][2].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter12++;
                if(buttons[2][3].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter13++;

                if(buttons[3][0].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter14++;
                if(buttons[3][1].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter15++;
                if(buttons[3][2].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter16++;
                if(buttons[3][3].getText().toString().equals(buttons[i][m].getText().toString()))
                    counter17++;



            }
//                Integer x= (Integer) Integer.getInteger(String.valueOf(buttons[1][1]));

            // }

//            Toast.makeText(NationalLottery.this, "counter is " +counter5, Toast.LENGTH_LONG).show();
            if(counter2>=3 && counter2>counter3 &&counter2>counter4 &&counter2>counter5 &&counter2>counter6
                    &&counter2>counter7 &&counter2>counter8 &&counter2>counter9 &&counter2>counter10
                    &&counter2>counter11 &&counter2>counter12 &&counter2>counter13 &&counter2>counter14
                    &&counter2>counter15 &&counter2>counter16 &&counter2>counter17) {



                if(counter2==3)
                {

                Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                if (!NationalLotteryEmail.isEmpty()) {
                    //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                    NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "3");
                    databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                } else
                    Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



              else  if(counter2==4)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "5");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter2==5)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "10");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==6)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "25");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter2==7)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "85");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==8)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "250");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==9)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "1000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==10)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "3000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==11)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "10,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter2==12)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "30,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter2==13)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter2 + " And The number is " + buttons[0][0].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][0].getText().toString(), counter2, "75,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(NationalLottery.this, "No prise", Toast.LENGTH_SHORT).show();


            }



            else if(counter3>=3 &&counter3>counter4 &&counter3>counter5 &&counter3>counter6
                    &&counter3>counter7 &&counter3>counter8 &&counter3>counter9 &&counter3>counter10
                    &&counter3>counter11 &&counter3>counter12 &&counter3>counter13 &&counter3>counter14
                    &&counter3>counter15 &&counter3>counter16 &&counter3>counter17) {





//                Toast.makeText(NationalLottery.this, "counter is " + counter3 + "And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();
//                // Toast.makeText(NationalLottery.this, "counter is " + counter2 + "And The number is "+buttons[0][0], Toast.LENGTH_LONG).show();
//
//                if (!NationalLotteryEmail.isEmpty()) {
//                    //the below is  (Email,frequency,the number itself,and amount of birr it holds)
//                    NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter2, "10");
//                    databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
////                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
//                } else
//                    Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();




                if(counter3==3)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "3");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter3==4)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "5");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter3==5)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "10");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==6)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "25");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter3==7)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "85");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==8)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "250");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==9)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "1000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==10)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "3000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==11)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "10,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }


                else  if(counter3==12)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "30,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }



                else  if(counter3==13)
                {

                    Toast.makeText(NationalLottery.this, "counter is " + counter3 + " And The number is " + buttons[0][1].getText().toString(), Toast.LENGTH_LONG).show();

                    if (!NationalLotteryEmail.isEmpty()) {
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel = new NationalLotteryModel(NationalLotteryEmail,buttons[0][1].getText().toString(), counter3, "75,000");
                        databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    } else
                        Toast.makeText(NationalLottery.this, "Enter Email", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(NationalLottery.this, "No prise", Toast.LENGTH_SHORT).show();

            }















            else if(counter4>=3 &&counter4>counter5 &&counter4>counter6
                    &&counter4>counter7 &&counter4>counter8 &&counter4>counter9 &&counter4>counter10
                    &&counter4>counter11 &&counter4>counter12 &&counter4>counter13 &&counter4>counter14
                    &&counter4>counter15 &&counter4>counter16 &&counter4>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter4 + "And The number is "+buttons[0][2].getText().toString(), Toast.LENGTH_LONG).show();



            else if(counter5>=3 &&counter5>counter6
                    &&counter5>counter7 &&counter5>counter8 &&counter5>counter9 &&counter5>counter10
                    &&counter5>counter11 &&counter5>counter12 &&counter5>counter13 &&counter5>counter14
                    &&counter5>counter15 &&counter5>counter16 &&counter5>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter5 + "And The number is "+buttons[0][3].getText().toString(), Toast.LENGTH_LONG).show();


            else if(counter6>=3
                    &&counter6>counter7 &&counter6>counter8 &&counter6>counter9 &&counter6>counter10
                    &&counter6>counter11 &&counter6>counter12 &&counter6>counter13 &&counter6>counter14
                    &&counter6>counter15 &&counter6>counter16 &&counter6>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter6 + "And The number is "+buttons[1][0].getText().toString(), Toast.LENGTH_LONG).show();



            else if(counter7>=3
                    &&counter7>counter8 &&counter7>counter9 &&counter7>counter10
                    &&counter7>counter11 &&counter7>counter12 &&counter7>counter13 &&counter7>counter14
                    &&counter7>counter15 &&counter7>counter16 &&counter7>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter7 + "And The number is "+buttons[1][1].getText().toString(), Toast.LENGTH_LONG).show();



            else if(counter8>=3
                    &&counter8>counter9 &&counter8>counter10
                    &&counter8>counter11 &&counter8>counter12 &&counter8>counter13 &&counter8>counter14
                    &&counter8>counter15 &&counter8>counter16 &&counter8>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter8 + "And The number is "+buttons[1][2].getText().toString(), Toast.LENGTH_LONG).show();


            else if(counter9>=3
                    &&counter9>counter10
                    &&counter9>counter11 &&counter9>counter12 &&counter9>counter13 &&counter9>counter14
                    &&counter9>counter15 &&counter9>counter16 &&counter9>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter9 + "And The number is "+buttons[1][3].getText().toString(), Toast.LENGTH_LONG).show();


            else if(counter10>=3
                    &&counter10>counter11 &&counter10>counter12 &&counter10>counter13 &&counter10>counter14
                    &&counter10>counter15 &&counter10>counter16 &&counter10>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter10 + "And The number is "+buttons[2][0].getText().toString(), Toast.LENGTH_LONG).show();



            else if(counter11>=3
                    &&counter11>counter12 &&counter11>counter13 &&counter11>counter14
                    &&counter11>counter15 &&counter11>counter16 &&counter11>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter11 + "And The number is "+buttons[2][1].getText().toString(), Toast.LENGTH_LONG).show();


            else if(counter12>=3
                    &&counter12>counter13 &&counter12>counter14
                    &&counter12>counter15 &&counter12>counter16 &&counter12>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter12 + "And The number is "+buttons[2][2].getText().toString(), Toast.LENGTH_LONG).show();


            else if(counter13>=3
                    &&counter13>counter14
                    &&counter13>counter15 &&counter13>counter16 &&counter13>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter13 + "And The number is "+buttons[2][3].getText().toString(), Toast.LENGTH_LONG).show();

            else if(counter14>=3
                    &&counter14>counter15 &&counter14>counter16 &&counter14>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter14 + "And The number is "+buttons[3][0].getText().toString(), Toast.LENGTH_LONG).show();

            else if(counter15>=3
                    &&counter15>counter16 &&counter15>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter15 + "And The number is "+buttons[3][1].getText().toString(), Toast.LENGTH_LONG).show();

            else if(counter16>=3
                    &&counter16>counter17)
                Toast.makeText(NationalLottery.this, "counter is " + counter16 + "And The number is "+buttons[3][2].getText().toString(), Toast.LENGTH_LONG).show();

            else
                Toast.makeText(NationalLottery.this, "No prise", Toast.LENGTH_LONG).show();




        }


    }



    public void toDisable(View view) {
        counter++;

        tryAnotherNumber.setText(Integer.toString(counter));

    }



}

