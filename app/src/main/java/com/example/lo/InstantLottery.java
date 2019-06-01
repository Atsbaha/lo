package com.example.lo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lo.viewModels.InstantModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class InstantLottery extends AppCompatActivity{

    private Button[][] buttons=new Button[5][3];
    private Button[][] buttonsAre=new Button[7][9];
    DatabaseReference databaseReference;

    private TextView txt;
    Button tryAnotherNumber,getTicketNumber;
    EditText view;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_lottery);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Instant Lottery Email And TicketNumber");




//        txt=findViewById(R.id.text_view_p1);

        tryAnotherNumber=findViewById(R.id.tryAnotherNumber);

        getTicketNumber=findViewById(R.id.getTicketNumber);
        view=findViewById(R.id.viewNumber);
        String Email=view.getText().toString();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewNumberr();
            }
        });


        getTicketNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTicketNumber();
            }
        });

//        if(getTicketNumber.isClickable())
//            getTicketNumber.setEnabled(false);
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                String buttonID="button_" +i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);

            }
        }


        for(int i=0;i<7;i++)
        {
            for(int j=0;j<9;j++)
            {
                String buttonIndicator="button_a" +i+j;
                int resID=getResources().getIdentifier(buttonIndicator,"id",getPackageName());

                buttonsAre[i][j]=findViewById(resID);
//
            }
        }

    }

    public void showTicketNumber() {

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
                buttons[i][j].setText(myString);

               /* if(buttons[0][0].equals(buttons[0][1]) && buttons[0][1].equals(buttons[0][2])
                        || buttons[1][0].equals(buttons[1][1]) && buttons[1][1].equals(buttons[1][2])
                        || buttons[2][0].equals(buttons[2][1]) && buttons[2][1].equals(buttons[2][2])
                        || buttons[3][0].equals(buttons[3][1]) && buttons[3][1].equals(buttons[3][2])
                        || buttons[4][0].equals(buttons[4][1]) && buttons[4][1].equals(buttons[4][2])

                        || buttons[0][0].equals(buttons[1][0]) && buttons[1][0].equals(buttons[2][0])
                        && buttons[2][0].equals(buttons[3][0]) && buttons[3][0].equals(buttons[4][0])
                        || buttons[0][1].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][1])
                        && buttons[2][1].equals(buttons[3][1]) && buttons[3][1].equals(buttons[4][1])
                        || buttons[0][2].equals(buttons[1][2]) && buttons[1][2].equals(buttons[2][2])
                        && buttons[2][2].equals(buttons[3][2]) && buttons[3][2].equals(buttons[4][2]))
                {
                    Toast.makeText(InstantLottery.this,"Successful",Toast.LENGTH_SHORT).show();
                    getTicketNumber.setEnabled(false);//wala success ykun bdhriu disable kkon alewo
                }
                else
                    Toast.makeText(InstantLottery.this,"Not Successful",Toast.LENGTH_SHORT).show();
                getTicketNumber.setEnabled(false);*/
               String Email=view.getText().toString();

                ViewNumberr();
                if(buttonsAre[3][8].getText().toString().equals(buttons[i][j].getText().toString())){


                    Toast.makeText(InstantLottery.this,"5 birr prise", Toast.LENGTH_SHORT).show();
//                String ticketNumber=buttonsAre[3][8].getText().toString();
                InstantModel instantModel=new InstantModel(Email,buttonsAre[3][8].getText().toString(),"5");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
                }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();


                if(buttonsAre[3][0].getText().toString().equals(buttons[i][j].getText().toString())){


                    Toast.makeText(InstantLottery.this,"5 birr prise", Toast.LENGTH_SHORT).show();
//                String ticketNumber=buttonsAre[3][8].getText().toString();
                    InstantModel instantModel=new InstantModel(Email,buttonsAre[3][0].getText().toString(),"5");
                    databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
                }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();


                if(buttonsAre[0][3].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[0][4].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[0][5].getText().toString().equals(buttons[i][j].getText().toString())){


                    Toast.makeText(InstantLottery.this,"15 birr prise", Toast.LENGTH_SHORT).show();

                InstantModel instantModel=new InstantModel(Email,buttonsAre[0][3].getText().toString()+","
                        +buttonsAre[0][4].getText().toString()+","+buttonsAre[0][5].getText().toString(),"15");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();




                if(buttonsAre[1][2].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[1][3].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[1][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[1][5].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[1][6].getText().toString().equals(buttons[i][j].getText().toString())){
                    Toast.makeText(InstantLottery.this,"50 birr prise", Toast.LENGTH_SHORT).show();

                InstantModel instantModel=new InstantModel(Email,buttonsAre[1][2].getText().toString()+","
                    +buttonsAre[1][3].getText().toString()+","+buttonsAre[1][4].getText().toString()+","+
                    buttonsAre[1][5].getText().toString()+","+ buttonsAre[1][6].getText().toString(),"50");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();




                if(buttonsAre[2][1].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[2][2].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[2][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][4].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[2][5].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[2][6].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[2][7].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"5000 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[2][1].getText().toString()+","
                        +buttonsAre[2][2].getText().toString()+","+buttonsAre[2][3].getText().toString()+","+
                        buttonsAre[2][4].getText().toString()+","+ buttonsAre[2][5].getText().toString()+","
                        +buttonsAre[2][6].getText().toString()+","+ buttonsAre[2][7].getText().toString(),"5000");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();


                if(buttonsAre[3][0].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][1].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][2].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][3].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][4].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][5].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][6].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][7].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[3][8].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"75000 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[3][0].getText().toString()+","
                        +buttonsAre[3][1].getText().toString()+","+buttonsAre[3][2].getText().toString()+","+
                        buttonsAre[3][3].getText().toString()+","+ buttonsAre[3][4].getText().toString()+","
                        +buttonsAre[3][5].getText().toString()+","+ buttonsAre[3][6].getText().toString()+","+
                        buttonsAre[3][7].getText().toString()+","+buttonsAre[3][8].getText().toString(),"75000");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();


                if(buttonsAre[4][1].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[4][2].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[4][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][4].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[4][5].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[4][6].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[4][7].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"1000 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[4][1].getText().toString()+","
                        + buttonsAre[4][2].getText().toString()+","+buttonsAre[4][3].getText().toString()+","+
                        buttonsAre[4][4].getText().toString()+","+ buttonsAre[4][5].getText().toString()+","
                        +buttonsAre[4][6].getText().toString()+","+ buttonsAre[4][7].getText().toString(),"1000");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();



                if(buttonsAre[5][2].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[5][3].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[5][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][5].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[5][6].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"50 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[5][2].getText().toString()+","
                        + buttonsAre[5][3].getText().toString()+","+buttonsAre[5][4].getText().toString()+","+
                        buttonsAre[5][5].getText().toString()+","+ buttonsAre[5][6].getText().toString(),"50");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();


                if(buttonsAre[6][3].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[6][4].getText().toString().equals(buttons[i][j].getText().toString()) &&
                        buttonsAre[6][5].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"50 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[6][3].getText().toString()+","
                        + buttonsAre[6][4].getText().toString()+","+ buttonsAre[6][5].getText().toString(),"50");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();



                if(buttonsAre[3][0].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"5 birr prise", Toast.LENGTH_SHORT).show();




                /*int k1=1;
                for(int m=2;m<=4;i++){
                    if(buttons[m][k1].equals(buttons[i][j])){
                        Toast.makeText(InstantLottery.this,"5 birr prise", Toast.LENGTH_SHORT).show();
                    }
                }*/


                if(buttonsAre[2][1].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][1].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][1].getText().toString().equals(buttons[i][j].getText().toString()))
                {
                    Toast.makeText(InstantLottery.this,"10 birr prise", Toast.LENGTH_SHORT).show();


                InstantModel instantModel=new InstantModel(Email,buttonsAre[2][1].getText().toString()+","
                        + buttonsAre[3][1].getText().toString()+","+ buttonsAre[4][1].getText().toString(),"10");
                databaseReference.setValue(instantModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);
            }else  Toast.makeText(InstantLottery.this,"Not Win", Toast.LENGTH_SHORT).show();








                //continue



                if(buttonsAre[1][2].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][2].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][2].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][2].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][2].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"100 birr prise", Toast.LENGTH_SHORT).show();


                if(buttonsAre[0][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[1][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][3].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[6][3].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"25,000 birr prise", Toast.LENGTH_SHORT).show();


                if(buttonsAre[0][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[1][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][4].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[6][4].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"150,000 birr prise", Toast.LENGTH_SHORT).show();


                if(buttonsAre[0][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[1][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][5].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[6][5].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"10,000 birr prise", Toast.LENGTH_SHORT).show();



                if(buttonsAre[1][6].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[2][6].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][6].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][6].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[5][6].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"500 birr prise", Toast.LENGTH_SHORT).show();



                if(buttonsAre[2][7].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[3][7].getText().toString().equals(buttons[i][j].getText().toString())&&
                        buttonsAre[4][7].getText().toString().equals(buttons[i][j].getText().toString()))
                    Toast.makeText(InstantLottery.this,"10 birr prise", Toast.LENGTH_SHORT).show();

                //the last of this row and column is done at the beginning

            }
        }



    }

    public void ViewNumberr() {


        for(int i=0;i<7;i++)
        {
            for(int j=0;j<9;j++)
            {

                Random rand=new Random();
                int number=rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
                buttonsAre[i][j].setText(myString);

             /*   if(buttons[0][0].equals(buttons[0][1]) && buttons[0][1].equals(buttons[0][2])
                        || buttons[1][0].equals(buttons[1][1]) && buttons[1][1].equals(buttons[1][2])
                        || buttons[2][0].equals(buttons[2][1]) && buttons[2][1].equals(buttons[2][2])
                        || buttons[3][0].equals(buttons[3][1]) && buttons[3][1].equals(buttons[3][2])
                        || buttons[4][0].equals(buttons[4][1]) && buttons[4][1].equals(buttons[4][2])

                        || buttons[0][0].equals(buttons[1][0]) && buttons[1][0].equals(buttons[2][0])
                        && buttons[2][0].equals(buttons[3][0]) && buttons[3][0].equals(buttons[4][0])
                        || buttons[0][1].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][1])
                        && buttons[2][1].equals(buttons[3][1]) && buttons[3][1].equals(buttons[4][1])
                        || buttons[0][2].equals(buttons[1][2]) && buttons[1][2].equals(buttons[2][2])
                        && buttons[2][2].equals(buttons[3][2]) && buttons[3][2].equals(buttons[4][2]))
                {
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                    getTicketNumber.setEnabled(false);//wala success ykun bdhriu disable kkon alewo
                }
                else
                    Toast.makeText(MainActivity.this,"Not Successful",Toast.LENGTH_SHORT).show();
                getTicketNumber.setEnabled(false);

*/
            }
        }




    }



    public void toDisable(View view) {
        counter++;

        tryAnotherNumber.setText(Integer.toString(counter));

    }



}
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lo.viewModels.InstantModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class InstantLottery extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference databaseReference;

    private Button[][] buttons=new Button[5][3];

    private TextView txt;
    Button tryAnotherNumber,getTicketNumber;
    EditText instantEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_lottery);


        //initialize firebase


//        txt=findViewById(R.id.text_view_p1);
        instantEmail=findViewById(R.id.instantEmail);

        tryAnotherNumber=findViewById(R.id.tryAnotherNumber);

        getTicketNumber=findViewById(R.id.getTicketNumber);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Instant Lottery Email And TicketNumber");

        getTicketNumber.setOnClickListener(this);
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                String buttonID="button_" +i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);

            }
        }

    }

    @Override
    public void onClick(View v) {
        String Emaill = instantEmail.getText().toString();
        if (!Emaill.isEmpty())
        {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {

                    Random rand = new Random();
                    int number = rand.nextInt(89) + 10;

//                TextView mytext=(TextView)findViewById(R.id.textView);
                    String myString = String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
                    buttons[i][j].setText(myString);

                    InstantModel instantModel=new InstantModel(Emaill,myString);
                    databaseReference.push().setValue(instantModel);

                    if (buttons[0][0].equals(buttons[0][1]) && buttons[0][1].equals(buttons[0][2])
                            || buttons[1][0].equals(buttons[1][1]) && buttons[1][1].equals(buttons[1][2])
                            || buttons[2][0].equals(buttons[2][1]) && buttons[2][1].equals(buttons[2][2])
                            || buttons[3][0].equals(buttons[3][1]) && buttons[3][1].equals(buttons[3][2])
                            || buttons[4][0].equals(buttons[4][1]) && buttons[4][1].equals(buttons[4][2])

                            || buttons[0][0].equals(buttons[1][0]) && buttons[1][0].equals(buttons[2][0])
                            && buttons[2][0].equals(buttons[3][0]) && buttons[3][0].equals(buttons[4][0])
                            || buttons[0][1].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][1])
                            && buttons[2][1].equals(buttons[3][1]) && buttons[3][1].equals(buttons[4][1])
                            || buttons[0][2].equals(buttons[1][2]) && buttons[1][2].equals(buttons[2][2])
                            && buttons[2][2].equals(buttons[3][2]) && buttons[3][2].equals(buttons[4][2])) {
                        Toast.makeText(InstantLottery.this, "Successful", Toast.LENGTH_SHORT).show();
                        getTicketNumber.setEnabled(false);
                    } else
                        Toast.makeText(InstantLottery.this, "Not Successful", Toast.LENGTH_SHORT).show();
                    getTicketNumber.setEnabled(false);
                }

            }
    }
        else
        {
            Toast.makeText(InstantLottery.this,"Enter your Email",Toast.LENGTH_SHORT).show();
        }



    }
}
*/