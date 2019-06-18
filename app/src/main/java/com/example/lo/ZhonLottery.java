package com.example.lo;

import android.content.Intent;
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

import com.example.lo.Common.Common;
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
    Button btn,btnWrite,btnRead,btnUniqueNumber,btnZhonChecking,zhonNext,btnOrderNumber;
    EditText EnterEmail,edtZhonChecking;
    TextView random,txtView;
    long maxId=0;



    DatabaseReference databaseReference,btnReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhon_lottery);

        btnZhonChecking=findViewById(R.id.btnZhonChecking);
        edtZhonChecking=findViewById(R.id.edtZhonChecking);

        btnOrderNumber=findViewById(R.id.btnOrderNumber);



        btn=findViewById(R.id.btnZhonLottery);
        EnterEmail=(EditText)findViewById(R.id.EnterEmail);
        random=(TextView)findViewById(R.id.textView);

        zhonNext=findViewById(R.id.zhonNext);


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



        zhonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ZhonLottery.this,EachPayment.class);
                startActivity(intent);
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




      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              generateTicketNumber();

              CheckrResult();

              btnReference=FirebaseDatabase.getInstance().getReference().child("Zhon Lottery Email And TicketNumber");
//              btnReference.addValueEventListener(new ValueEventListener() {
//                  @Override
//                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                      if(dataSnapshot.exists())
////                      {
//                       maxId=dataSnapshot.getChildrenCount();
////            String orderNumber=dataSnapshot.child(String.valueOf(maxId)).getValue().toString();
////
////             String btnNumber=dataSnapshot.child(String.valueOf(maxId++)).child("uniquqNumber").getValue().toString();
////                      btnUniqueNumber.setText(btnNumber);
////
////                      btnOrderNumber.setText(orderNumber);
////                      }
//
//
//
//
//
//
//                  }
//
//                  @Override
//                  public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                  }
//              });





//change the below to addValueEventListener if not works
 btnReference.addListenerForSingleValueEvent(new ValueEventListener() {
     @Override
     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
         if(dataSnapshot.child(Common.currentUser.getPhone()).exists()){
             String btnNumber=dataSnapshot.child(Common.currentUser.getPhone()).child("uniquqNumber").getValue().toString();
                     btnUniqueNumber.setText(btnNumber);

         }
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
        View layout_pwd=inflater.inflate(R.layout.zhoncheckinglayout,null);

         EditText edtchecking=layout_pwd.findViewById(R.id.edtZhonChecking);
         Button btnChecking=layout_pwd.findViewById(R.id.btnZhonChecking);
         final String EnteredNumber=edtchecking.getText().toString();



      btnChecking.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              databaseReference.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                     String Number=dataSnapshot.child("ticktNumber").getValue().toString();
                     if(Number.equals(EnteredNumber)){
                         Toast.makeText(ZhonLottery.this,"You won Lottery",Toast.LENGTH_SHORT).show();
                     }
                     else{
                         Toast.makeText(ZhonLottery.this,"You do not win Lottery",Toast.LENGTH_SHORT).show();
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



//              String key=databaseReference.push().getKey();

              String andegnaEta="Andegna Eta";
              ZhonModel zhonModel = new ZhonModel(Email, myString,GetUniqueNumber(10),andegnaEta);
//              String x=String.valueOf(maxId+1);

//              databaseReference.child(x).setValue(zhonModel);

             databaseReference.child(Common.currentUser.getPhone()).setValue(zhonModel);




//              databaseReference.setValue(zhonModel);//to enter a value and overwrite if another is entered
//              databaseReference.push().setValue(zhonModel);//to enter unique value in the database

//             databaseReference.child(key).setValue(zhonModel);

          }
          else
          {
              Toast.makeText(ZhonLottery.this, "Enter your Email ", Toast.LENGTH_SHORT).show();
          }



    }


}


