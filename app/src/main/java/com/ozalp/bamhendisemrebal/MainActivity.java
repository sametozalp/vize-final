package com.ozalp.bamhendisemrebal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText vize, finall, odev;
    TextView sonuc;
    EditText vize2;
    TextView sonuc2;
    int ortalama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vize = findViewById(R.id.vizeEditText);
        finall = findViewById(R.id.finalEditText);
        odev = findViewById(R.id.odevEditText);
        sonuc = findViewById(R.id.sonucTextView);
        vize2 = findViewById(R.id.vizeEditText2);
        sonuc2 = findViewById(R.id.sonucTextView2);
        ortalama = 0;
    }

    public void hesapla(View view) {
        //eğer ödev yoksa
        if(odev.getText().toString().equals("")){
            ortalama = ((Integer.parseInt(vize.getText().toString()) * 40 / 100) + (Integer.parseInt(finall.getText().toString()) * 60 /100));
        }
        //eğer ödev varsa
        else {
            ortalama = ((Integer.parseInt(vize.getText().toString()) * 25 / 100) + (Integer.parseInt(finall.getText().toString()) * 50 /100) + (Integer.parseInt(odev.getText().toString()) * 25 /100));
        }

        if(ortalama < 60) {
            sonuc.setText("Ortalamanız: " + ortalama + "\n Geçmeniz için gereken not: " + (60 - ortalama));
        } else {
            sonuc.setText("Ortalamanız: " + ortalama + "\n Geçtiniz Tebrikler.");
        }
    }

    public void hesapla2(View view) {
        double finaldenAlinmasiGerekenNot = (60 - (Double.parseDouble(vize2.getText().toString())  * 40 / 100)) * 100 / 60;
        if(finaldenAlinmasiGerekenNot < 60) {
            sonuc2.setText("Finalden almanız gereken not: " + 60);
        } else {
            sonuc2.setText("Finalden almanız gereken not: " + finaldenAlinmasiGerekenNot);
        }
    }
}