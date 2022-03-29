package com.example.activity_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextSoTienGui, editTextLaiSuat, editTextKyhan;
    Button btnXemKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();

        btnXemKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(editTextSoTienGui.getText().toString().isEmpty()  || editTextLaiSuat.getText().toString().isEmpty()|| editTextKyhan.getText().toString().isEmpty() ){
                    Toast.makeText(MainActivity.this, "Xin hãy nhập đầy đủ thông tin!!!", Toast.LENGTH_LONG).show();
                    }else {
                        long SoTienGui = Integer.parseInt( editTextSoTienGui.getText().toString());
                        double LaiSuat = Double.parseDouble( editTextLaiSuat.getText().toString());
                        int KyHan = Integer.parseInt( editTextKyhan.getText().toString());
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("SoTienGui", SoTienGui);
                        intent.putExtra("LaiSuat", LaiSuat);
                        intent.putExtra("KyHan", KyHan);
                        startActivity(intent);

                    }
            }
        });



    }

    private void Mapping(){
        editTextSoTienGui = (EditText) findViewById(R.id.editTextNhapTienGui);
        editTextLaiSuat = (EditText) findViewById(R.id.editTextNhapLaiSuat);
        editTextKyhan = (EditText) findViewById(R.id.editTextNhapKyHan);
        btnXemKQ = (Button) findViewById(R.id.btnXemKq);
    }
}