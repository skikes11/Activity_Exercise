package com.example.activity_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView TextViewSoTienLai, TextViewTongSoTien;
    Button btnTakePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Mapping();
        Intent intent = getIntent();

        long SoTienGui = intent.getLongExtra("SoTienGui", 0);
        double LaiSuat = intent.getDoubleExtra("LaiSuat", 0.0);
        int KyHan =  intent.getIntExtra("KyHan", 0);

        long SoTienLai = (long) (SoTienGui*LaiSuat/100*(KyHan*30/360));
        long TongSoTien = (long) (SoTienGui+SoTienLai);

        TextViewSoTienLai.setText(SoTienLai + " VND");
        TextViewTongSoTien.setText(TongSoTien+ " VND");

        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent1);
            }
        });

    }

    private void Mapping(){
        TextViewSoTienLai = (TextView) findViewById(R.id.textViewSoTienLai);
        TextViewTongSoTien = (TextView) findViewById(R.id.textViewSoTongTien);
        btnTakePic = (Button) findViewById(R.id.btnTakePic);
    }
}