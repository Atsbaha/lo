package com.example.lo;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private EditText phone;
    private EditText amountt;
    private EditText pinn;
    Button btnNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("RECHARGE SUBSCRIBE ACCOUNT");

        phone = findViewById(R.id.phonenumber);
        amountt = findViewById(R.id.amount);
        pinn = findViewById(R.id.pin);
        Button forother = findViewById(R.id.recharge);

        btnNumber=findViewById(R.id.btnNumber);

        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String number = phone.getText().toString();
                final String number2 = amountt.getText().toString();
                final String number3 = pinn.getText().toString();


                if(!number.isEmpty() &&!number2.isEmpty() && !number3.isEmpty()){


//                Intent intent =new Intent(Payment.this,ZhonLottery.class);
//                startActivity(intent);
                Toast.makeText(Payment.this, "Thank you You have finished ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Payment.this, "Each Field Is Required", Toast.LENGTH_SHORT).show();

            }
        });

        forother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forother();
            }
        });
    }

    private void forother() {
        final String number = phone.getText().toString();
        final String number2 = amountt.getText().toString();
        final String number3 = pinn.getText().toString();
        if ((number.trim().isEmpty()) || (number2.trim().isEmpty()) || (number3.trim().isEmpty()))
        {
            Toast.makeText(Payment.this, "All fields are required ", Toast.LENGTH_SHORT).show();
        }
        else if (number3.trim().length() != 4){
            Toast.makeText(Payment.this, "Wrong Pin Number \n The PIN number must contain 4-digit ", Toast.LENGTH_SHORT).show();
        }
        else if (number.trim().length() != 10){
            Toast.makeText(Payment.this, "Invalid phone number ", Toast.LENGTH_SHORT).show();
        }

        else {

            if (ContextCompat.checkSelfPermission(Payment.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Payment.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Send Money");
                builder.setMessage("Are you sure you Want to Send?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        String dial1 = "*847*3*2*1*" + number + "*" + number2 + "*" + number3 + "*1";
                        String dial1 = "*889*3*2*1*" + number + "*" + number2 + "*" + number3 + "*1";
                        String dial = "tel:" + dial1;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Uri.parse(dial)+ Uri.encode("#"))));


                        Intent intent=new Intent(Payment.this,IntentToLotteryTypes.class);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.show();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                forother();
            } else {

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Permission DENIED");
                builder.setMessage("Are You sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        forother();
                    }
                });
                builder.show();
            }
        }
    }

}
