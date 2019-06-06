package com.example.lo;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Lyu2Lottery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyu2_lottery);
    }
}


*/


import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lo.viewModels.Lyu2Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Lyu2Lottery extends AppCompatActivity {
    Button btnLyu2,btnLyu2Write,btnLyu2Read,btnLyu2UniqueNumber,btnLyu2Checking;
    EditText EnterLyu2Email,edtLyu2Checking;
    TextView Lyu2random,Lyu2txtView;



    DatabaseReference databaseReference,btnLyu2Reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyu2_lottery);

        btnLyu2Checking=findViewById(R.id.btnLyu2Checking);
        edtLyu2Checking=findViewById(R.id.edtLyu2Checking);



        btnLyu2=findViewById(R.id.btnLyu2Lottery);
        EnterLyu2Email=(EditText)findViewById(R.id.EnterLyu2Email);
        Lyu2random=(TextView)findViewById(R.id.Lyu2textView);


        btnLyu2Write=findViewById(R.id.btnLyu2Write);
        btnLyu2Read=findViewById(R.id.btnLyu2Read);
        Lyu2txtView=findViewById(R.id.Lyu2NumberShower);

        btnLyu2UniqueNumber=findViewById(R.id.btnLyu2UniqueNumber);


        btnLyu2Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExternalMessage();
            }
        });

        btnLyu2Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readExternalMessage();
            }
        });


//        String key=databaseReference.push().getKey();


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Lyu2 Lottery Email And TicketNumber");




        btnLyu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateTicketNumber();

                CheckrResult();

                btnLyu2Reference=FirebaseDatabase.getInstance().getReference().child("Lyu2 Lottery Email And TicketNumber");
                btnLyu2Reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String btnNumber=dataSnapshot.child("lyu2uniquqNumber").getValue().toString();
                        btnLyu2UniqueNumber.setText(btnNumber);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    private void CheckrResult() {

        LayoutInflater inflater=LayoutInflater.from(this);
        View layout_pwd=inflater.inflate(R.layout.lyu2checkinglayout,null);

        EditText edtchecking=layout_pwd.findViewById(R.id.edtLyu2Checking);
        Button btnChecking=layout_pwd.findViewById(R.id.btnLyu2Checking);
        final String EnteredNumber=edtchecking.getText().toString();



        btnChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String Number=dataSnapshot.child("lyu2ticktNumber").getValue().toString();
                        if(Number.equals(EnteredNumber)){
                            Toast.makeText(Lyu2Lottery.this,"You won Lottery",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Lyu2Lottery.this,"You do not win Lottery",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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

    public void readExternalMessage(){
        File Root= Environment.getExternalStorageDirectory();
        File Dir=new File(Root.getAbsolutePath()+"/MyAppFile");
        File file=new File(Dir,"MyMessage.txt");

        String Message;
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((Message=bufferedReader.readLine())!=null)
            {

                stringBuffer.append(Message + "\n");
            }
            Lyu2txtView.setText(stringBuffer.toString());
            Lyu2txtView.setVisibility(View.VISIBLE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeExternalMessage(){
        String state;
        state= Environment.getExternalStorageState();

        //checks if the media is available
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File Root= Environment.getExternalStorageDirectory();
            //the path of the folder with its name
            File Dir=new File(Root.getAbsolutePath()+"/MyAppFile");
            if(Dir.exists())
            {
                Dir.mkdir();
            }
            //Directory name and name of the file
            File file=new File(Dir,"MyMessage.txt");

            String Message=Lyu2random.getText().toString();
            //String Message=editText.getText().toString();
            try{
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(Message.getBytes());
                fileOutputStream.close();
                Lyu2random.setText(""); //reseting the editText
                Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_LONG).show();



            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),"SD card Not Found",Toast.LENGTH_LONG).show();
        }


    }

    private void generateTicketNumber() {
        GetUniqueNumber(10);


        String Email=EnterLyu2Email.getText().toString();
        if(!Email.isEmpty()) {
            Random rand=new Random();
            int number=rand.nextInt(999999999) + 100000000;

            TextView mytext=(TextView)findViewById(R.id.textView);
            String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
            mytext.setText(myString);

//        LoginActivity loginActivity=new LoginActivity();


//                     btnUniqueNumber.setText(GetUniqueNumber(10));



            String key=databaseReference.push().getKey();

            String andegnaEta="Andegna Eta";
            Lyu2Model lyu2Model = new Lyu2Model(Email, myString,GetUniqueNumber(10),andegnaEta);
            databaseReference.setValue(lyu2Model);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);

        }
        else
        {
            Toast.makeText(Lyu2Lottery.this, "Enter your Email ", Toast.LENGTH_SHORT).show();
        }



    }


}


