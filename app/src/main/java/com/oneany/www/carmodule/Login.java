package com.oneany.www.carmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class Login extends AppCompatActivity {

    Button b;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        result = (EditText)findViewById(R.id.id);
        b = (Button)findViewById(R.id.signin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //USE IF ELSE STATEMENT FOR LOGIN IN FIREBASE

                Intent ii = new Intent(Login.this,MainActivity.class);
                startActivity(ii);
                finish();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode== CommonStatusCodes.SUCCESS){
                if(data!=null){
                    Barcode barcode = data.getParcelableExtra("qr");
                    result.setText("" + barcode.displayValue);


                }else {
                    result.setText("");
                }
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void scanResult(View view) {
        Intent intent = new Intent(Login.this, QRScan.class);
        startActivityForResult(intent,1);
    }
}
