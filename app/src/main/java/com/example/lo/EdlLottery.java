package com.example.lo;


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

import com.example.lo.viewModels.EdlModel;
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

public class EdlLottery extends AppCompatActivity {
    Button btnEdl,btnEdlWrite,btnEdlRead,btnEdlUniqueNumber,btnEdlChecking;
    EditText EnterEdlEmail,edtEdlChecking;
    TextView Edlrandom,EdltxtView;



    DatabaseReference databaseReference,btnEdlReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edl_lottery);

        btnEdlChecking=findViewById(R.id.btnEdlChecking);
        edtEdlChecking=findViewById(R.id.edtEdlChecking);



        btnEdl=findViewById(R.id.btnEdlLottery);
        EnterEdlEmail=(EditText)findViewById(R.id.EnterEdlEmail);
        Edlrandom=(TextView)findViewById(R.id.EdltextView);


        btnEdlWrite=findViewById(R.id.btnEdlWrite);
        btnEdlRead=findViewById(R.id.btnEdlRead);
        EdltxtView=findViewById(R.id.EdlNumberShower);

        btnEdlUniqueNumber=findViewById(R.id.btnEdlUniqueNumber);


        btnEdlWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExternalMessage();
            }
        });

        btnEdlRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readExternalMessage();
            }
        });


//        String key=databaseReference.push().getKey();


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Edl Lottery Email And TicketNumber");


//        generateTicketNumber();

//        CheckrResult();

      btnEdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateTicketNumber();

                CheckrResult();

                btnEdlReference=FirebaseDatabase.getInstance().getReference().child("Edl Lottery Email And TicketNumber");
                btnEdlReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String btnNumber=dataSnapshot.child("edluniquqNumber").getValue().toString();
                        btnEdlUniqueNumber.setText(btnNumber);
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
        View layout_pwd=inflater.inflate(R.layout.edlcheckinglayout,null);

        EditText edtchecking=layout_pwd.findViewById(R.id.edtEdlChecking);
        Button btnChecking=layout_pwd.findViewById(R.id.btnEdlChecking);
        final String EnteredNumber=edtchecking.getText().toString();



        btnChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String Number=dataSnapshot.child("ticktNumber").getValue().toString();
                        if(Number.equals(EnteredNumber)){
                            Toast.makeText(EdlLottery.this,"You won Lottery",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(EdlLottery.this,"You do not win Lottery",Toast.LENGTH_SHORT).show();
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
            EdltxtView.setText(stringBuffer.toString());
            EdltxtView.setVisibility(View.VISIBLE);


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

            String Message=Edlrandom.getText().toString();
            //String Message=editText.getText().toString();
            try{
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(Message.getBytes());
                fileOutputStream.close();
                Edlrandom.setText(""); //reseting the editText
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


        String Email=EnterEdlEmail.getText().toString();
        if(!Email.isEmpty()) {
            Random rand=new Random();
            int number=rand.nextInt(999999999) + 100000000;

            TextView mytext=(TextView)findViewById(R.id.EdltextView);
            String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
            mytext.setText(myString);

//        LoginActivity loginActivity=new LoginActivity();


//                     btnUniqueNumber.setText(GetUniqueNumber(10));



            String key=databaseReference.push().getKey();

            String andegnaEta="Andegna Eta";
            EdlModel edlModel = new EdlModel(Email, myString,GetUniqueNumber(10),andegnaEta);
            databaseReference.setValue(edlModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);

        }
        else
        {
            Toast.makeText(EdlLottery.this, "Enter your Email ", Toast.LENGTH_SHORT).show();
        }



    }


}


