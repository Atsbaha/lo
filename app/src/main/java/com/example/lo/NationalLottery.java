package com.example.lo;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NationalLottery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_lottery);
    }
}
*/


import android.content.Intent;
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
    int counter5=0;


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

                Intent intent=new Intent(NationalLottery.this,Payment.class);
                startActivity(intent);
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


                  String NationalLotteryEmail=edtEmail.getText().toString();



                if(buttons[0][0]==buttons[i][j])

                    counter2++;
               /* String myString0=String.valueOf(buttons[0][0]);







                 if(counter2==5){
                    Toast.makeText(NationalLottery.this,"10 Birr prise",Toast.LENGTH_LONG).show();

                    String x= String.valueOf(buttons[i][j]);
//                    txtNumberShowing.setText("Your Number "+ buttons[i][j]);
                    Toast.makeText(NationalLottery.this,"3 birr",Toast.LENGTH_LONG).show();
                    if(!NationalLotteryEmail.isEmpty()){
                        //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                        NationalLotteryModel nationalLotteryModel=new NationalLotteryModel(NationalLotteryEmail,myString,"5","10");
                       databaseReference.setValue(nationalLotteryModel);//to enter a value and overwrite if another is entered
//                        databaseReference.push().setValue(nationalLotteryModel);//to enter unique value in the database
                    }
                    else
                        Toast.makeText(NationalLottery.this,"Enter Email",Toast.LENGTH_LONG).show();

                }




                else if(counter2==6){
                    Toast.makeText(NationalLottery.this,"25 Birr prise",Toast.LENGTH_LONG).show();
//                     Toast.makeText(NationalLottery.this,"10 Birr prise",Toast.LENGTH_LONG).show();

                     String x= String.valueOf(buttons[i][j]);
//                     txtNumberShowing.setText("Your Number "+ buttons[i][j]);
                     Toast.makeText(NationalLottery.this,"25 birr",Toast.LENGTH_LONG).show();
                     if(!NationalLotteryEmail.isEmpty()){
                         //the below is  (Email,frequency,the number itself,and amount of birr it holds)
                         NationalLotteryModel nationalLotteryModel=new NationalLotteryModel(NationalLotteryEmail,myString,"6","25");
//                       databaseReference.setValue(zhonModel);//to enter a value and overwrite if another is entered
                         databaseReference.setValue(nationalLotteryModel);//to enter unique value in the database
                     }
                     else
                         Toast.makeText(NationalLottery.this,"Enter Email",Toast.LENGTH_LONG).show();

                }
                else if(counter2==7){
                    Toast.makeText(NationalLottery.this,"85 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==8){
                    Toast.makeText(NationalLottery.this,"250 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==9){
                    Toast.makeText(NationalLottery.this,"1000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==10){
                    Toast.makeText(NationalLottery.this,"3000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==11){
                    Toast.makeText(NationalLottery.this,"10,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==12){
                    Toast.makeText(NationalLottery.this,"30,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==13){
                    Toast.makeText(NationalLottery.this,"70,000 Birr prise",Toast.LENGTH_LONG).show();

                }
*/






                if(buttons[0][1]==buttons[i][j])

                    counter3++;

             /*

//                    Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(counter2==3){
                    Toast.makeText(NationalLottery.this,"3 birr",Toast.LENGTH_LONG).show();
                }
                else if(counter2==4){
                    Toast.makeText(NationalLottery.this,"5 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==5){
                    Toast.makeText(NationalLottery.this,"10 Birr prise",Toast.LENGTH_LONG).show();

                }

                else if(counter2==6){
                    Toast.makeText(NationalLottery.this,"25 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==7){
                    Toast.makeText(NationalLottery.this,"85 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==8){
                    Toast.makeText(NationalLottery.this,"250 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==9){
                    Toast.makeText(NationalLottery.this,"1000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==10){
                    Toast.makeText(NationalLottery.this,"3000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==11){
                    Toast.makeText(NationalLottery.this,"10,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==12){
                    Toast.makeText(NationalLottery.this,"30,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==13){
                    Toast.makeText(NationalLottery.this,"70,000 Birr prise",Toast.LENGTH_LONG).show();

                }

*/

                if(buttons[0][2]==buttons[i][j])

                    counter4++;

                /*

//                    Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(counter2==3){
                    Toast.makeText(NationalLottery.this,"3 birr",Toast.LENGTH_LONG).show();
                }
                else if(counter2==4){
                    Toast.makeText(NationalLottery.this,"5 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==5){
                    Toast.makeText(NationalLottery.this,"10 Birr prise",Toast.LENGTH_LONG).show();

                }

                else if(counter2==6){
                    Toast.makeText(NationalLottery.this,"25 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==7){
                    Toast.makeText(NationalLottery.this,"85 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==8){
                    Toast.makeText(NationalLottery.this,"250 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==9){
                    Toast.makeText(NationalLottery.this,"1000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==10){
                    Toast.makeText(NationalLottery.this,"3000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==11){
                    Toast.makeText(NationalLottery.this,"10,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==12){
                    Toast.makeText(NationalLottery.this,"30,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==13){
                    Toast.makeText(NationalLottery.this,"70,000 Birr prise",Toast.LENGTH_LONG).show();

                }



*/




                if(buttons[0][3]==buttons[i][j])

                    counter5++;





             /*
//                    Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(counter2==3){
                    Toast.makeText(NationalLottery.this,"3 birr",Toast.LENGTH_LONG).show();
                }
                else if(counter2==4){
                    Toast.makeText(NationalLottery.this,"5 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==5){
                    Toast.makeText(NationalLottery.this,"10 Birr prise",Toast.LENGTH_LONG).show();

                }

                else if(counter2==6){
                    Toast.makeText(NationalLottery.this,"25 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==7){
                    Toast.makeText(NationalLottery.this,"85 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==8){
                    Toast.makeText(NationalLottery.this,"250 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==9){
                    Toast.makeText(NationalLottery.this,"1000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==10){
                    Toast.makeText(NationalLottery.this,"3000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==11){
                    Toast.makeText(NationalLottery.this,"10,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==12){
                    Toast.makeText(NationalLottery.this,"30,000 Birr prise",Toast.LENGTH_LONG).show();

                }
                else if(counter2==13){
                    Toast.makeText(NationalLottery.this,"70,000 Birr prise",Toast.LENGTH_LONG).show();

                }*/

                    /*

                if(buttons[1][0]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[1][1]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[1][2]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[1][3]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[2][0]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[2][1]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[2][2]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[2][3]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[3][0]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[3][1]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[3][2]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();
                if(buttons[3][3]==buttons[i][j])

                    counter2++;
                Toast.makeText(NationalLottery.this,"Counter is "+counter2,Toast.LENGTH_LONG).show();*/


     if(counter2>counter3 && counter2>counter4 &&counter2>counter5&&counter2<=2)
     {
         Toast.makeText(NationalLottery.this, "No prise will be given", Toast.LENGTH_SHORT).show();
     }
               else if(counter2>counter3 && counter2>counter4 &&counter2>counter5&&counter2==3)
                {
                    Toast.makeText(NationalLottery.this, "3 birr prise", Toast.LENGTH_SHORT).show();
                    NationalLotteryModel nationalLotteryModel=new NationalLotteryModel(NationalLotteryEmail,myString,"3","3");
                    databaseReference.setValue(nationalLotteryModel);
                }
             else   if(counter2>counter3 && counter2>counter4 &&counter2>counter5&&counter2==4)
                {
                    Toast.makeText(NationalLottery.this, "5 birr prise", Toast.LENGTH_SHORT).show();
                    NationalLotteryModel nationalLotteryModel=new NationalLotteryModel(NationalLotteryEmail,myString,"4","5");
                    databaseReference.setValue(nationalLotteryModel);
                }





























            }
        }



    }
    public void toDisable(View view) {
        counter++;

        tryAnotherNumber.setText(Integer.toString(counter));

    }



}

