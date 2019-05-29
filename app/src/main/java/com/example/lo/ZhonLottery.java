package com.example.lo;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lo.viewModels.ZhonModel;
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

public class ZhonLottery extends AppCompatActivity {
    Button btn,btnWrite,btnRead,btnUniqueNumber;
    EditText EnterEmail;
    TextView random,txtView;



    DatabaseReference databaseReference,btnReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhon_lottery);



        btn=findViewById(R.id.btnZhonLottery);
        EnterEmail=(EditText)findViewById(R.id.EnterEmail);
        random=(TextView)findViewById(R.id.textView);


        btnWrite=findViewById(R.id.btnWrite);
        btnRead=findViewById(R.id.btnRead);
        txtView=findViewById(R.id.NumberShower);

        btnUniqueNumber=findViewById(R.id.btnUniqueNumber);


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExternalMessage();
            }
        });
        
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               readExternalMessage();  
            }
        });


//        String key=databaseReference.push().getKey();


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber");

      /*  btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateTicketNumber();
                btn.setEnabled(false);


                String key=databaseReference.child("U");


                btnUniqueNumber.setText(key);






//                DatabaseReference x= FirebaseDatabase.getInstance().getReference().child("National Lottery").child("frequency");
//                DatabaseReference x =FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber").child("uniquqNumber");
//                String y=String.valueOf(x);
//                int z=Integer.parseInt(y);

//                btnUniqueNumber.setText(FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber").child("uniquqNumber"));

//                btnUniqueNumber.setText(z);
            }
        });*/


      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              generateTicketNumber();

              btnReference=FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber");
              btnReference.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             String btnNumber=dataSnapshot.child("uniquqNumber").getValue().toString();
                      btnUniqueNumber.setText(btnNumber);
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
            txtView.setText(stringBuffer.toString());
            txtView.setVisibility(View.VISIBLE);


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

            String Message=random.getText().toString();
            //String Message=editText.getText().toString();
            try{
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(Message.getBytes());
                fileOutputStream.close();
                random.setText(""); //reseting the editText
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


          String Email=EnterEmail.getText().toString();
          if(!Email.isEmpty()) {
              Random rand=new Random();
              int number=rand.nextInt(999999999) + 100000000;

              TextView mytext=(TextView)findViewById(R.id.textView);
              String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
              mytext.setText(myString);

//        LoginActivity loginActivity=new LoginActivity();


//                     btnUniqueNumber.setText(GetUniqueNumber(10));



              String key=databaseReference.push().getKey();


              ZhonModel zhonModel = new ZhonModel(Email, myString,GetUniqueNumber(10));
              databaseReference.setValue(zhonModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);

          }
          else
          {
              Toast.makeText(ZhonLottery.this, "Enter your Email ", Toast.LENGTH_SHORT).show();
          }



    }

   /* public void generateTicketNumber(View view) {
        Random rand=new Random();
        int number=rand.nextInt(999999999) + 100000000;

        TextView mytext=(TextView)findViewById(R.id.textView);
        String myString=String.valueOf(number);//this is used to convert the number to String since TextView Displays Text
        mytext.setText(myString);
    }*/
}


