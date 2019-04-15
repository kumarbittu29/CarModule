package com.oneany.www.carmodule;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class Start extends AppCompatActivity {

    ImageView logo;
    Button lang,read,anc;
    CheckBox checkBox;

   /* Integer[] des = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,
            R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15,R.drawable.c16,R.drawable.c17,R.drawable.c18,R.drawable.c19,
            R.drawable.c20,R.drawable.c21,R.drawable.c22,R.drawable.c23,R.drawable.c24,R.drawable.c25,R.drawable.c26,R.drawable.c27,R.drawable.c28,R.drawable.c29,
            R.drawable.c30,R.drawable.c31,R.drawable.c32,R.drawable.c33};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_start);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        logo = (ImageView)findViewById(R.id.logoo) ;
        lang = (Button)findViewById(R.id.lang); 
        read = (Button)findViewById(R.id.read); 
        anc = (Button)findViewById(R.id.aac);
        checkBox = (CheckBox)findViewById(R.id.terms);

        anc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    Intent intent = new Intent(Start.this, Login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Start.this, R.string.readfirst, Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLangChange();
            }
        });

        
        

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Start.this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.carss));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        logo.setImageResource(R.mipmap.c1);
                        break;
                    case 1:
                        logo.setImageResource(R.mipmap.c2);
                        break;
                    case 2:
                        logo.setImageResource(R.mipmap.c3);
                        break;
                    case 3:
                        logo.setImageResource(R.mipmap.c4);
                        break;
                    case 4:
                        logo.setImageResource(R.mipmap.c5);
                        break;
                    case 5:
                        logo.setImageResource(R.mipmap.c6);
                        break;
                    case 6:
                        logo.setImageResource(R.mipmap.c7);
                        break;
                    case 7:
                        logo.setImageResource(R.mipmap.c8);
                        break;
                    case 8:
                        logo.setImageResource(R.mipmap.c9);
                        break;
                    case 9:
                        logo.setImageResource(R.mipmap.c10);
                        break;
                    case 10:
                        logo.setImageResource(R.mipmap.c11);
                        break;
                    case 11:
                        logo.setImageResource(R.mipmap.c12);
                        break;
                    case 12:
                        logo.setImageResource(R.mipmap.c13);
                        break;
                    case 13:
                        logo.setImageResource(R.mipmap.c14);
                        break;
                    case 14:
                        logo.setImageResource(R.mipmap.c15);
                        break;
                    case 15:
                        logo.setImageResource(R.mipmap.c16);
                        break;
                    case 16:
                        logo.setImageResource(R.mipmap.c17);
                        break;
                    case 17:
                        logo.setImageResource(R.mipmap.c18);
                        break;
                    case 18:
                        logo.setImageResource(R.mipmap.c19);
                        break;
                    case 19:
                        logo.setImageResource(R.mipmap.c20);
                        break;
                    case 20:
                        logo.setImageResource(R.mipmap.c21);
                        break;
                    case 21:
                        logo.setImageResource(R.mipmap.c22);
                        break;
                    case 22:
                        logo.setImageResource(R.mipmap.c23);
                        break;
                    case 23:
                        logo.setImageResource(R.mipmap.c24);
                        break;
                    case 24:
                        logo.setImageResource(R.mipmap.c25);
                        break;
                    case 25:
                        logo.setImageResource(R.mipmap.c26);
                        break;
                    case 26:
                        logo.setImageResource(R.mipmap.c27);
                        break;
                    case 27:
                        logo.setImageResource(R.mipmap.c28);
                        break;
                    case 28:
                        logo.setImageResource(R.mipmap.c29);
                        break;
                    case 29:
                        logo.setImageResource(R.mipmap.c30);
                        break;
                    case 30:
                        logo.setImageResource(R.mipmap.c31);
                        break;
                    case 31:
                        logo.setImageResource(R.mipmap.c32);
                        break;
                    case 32:
                        logo.setImageResource(R.mipmap.c33);
                        break;

                }

                Intent trans = new Intent();
                trans.putExtra("carname",position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void showLangChange() {
        final String[] listItems = {"English","Turkish"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Start.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0){
                    setLocale("en");
                    lang.setText("English");
                    recreate();
                }
                else if(i==1){
                    setLocale("tr");
                    lang.setText("Turkish");
                    recreate();
                }

                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration= new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My Lang",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My Lang","");
        setLocale(language);
    }

    public void showAlertD(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(Start.this).create();
        alertDialog.setTitle(R.string.terms);
        alertDialog.setMessage(getString(R.string.condition));
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}
