package com.oneany.www.carmodule;

import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import Adapter.WheelImageAdapter;
import Data.ImageData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {

    CursorWheelLayout wheelImage;
    List<ImageData> lstImage;
    TextView t;
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();

        loadData();

        wheelImage.setOnMenuSelectedListener(this);





    }

    private void loadData() {
        lstImage = new ArrayList<>();
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.start)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.horn)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.ac)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.window)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.sos)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.doors)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.lights)));
        lstImage.add(new ImageData(R.mipmap.btn,getString(R.string.lock)));
        WheelImageAdapter imgAdapter = new WheelImageAdapter(getBaseContext(),lstImage);
        wheelImage.setAdapter(imgAdapter);
    }

    private void initViews() {
        wheelImage = (CursorWheelLayout)findViewById(R.id.wheelImage);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if(parent.getId()==R.id.wheelImage){
        }
    }


}
