package com.example.calisma2_zaroyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class OyunAnaSayfa extends AppCompatActivity {
    public Button buttonTahmin;
    public TextView kalanHak;
    public TextView yonlendir;
    public EditText tahmin;
    public  int gelenTahmin;
    public  int randomSayi;
    public int sayac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ana_sayfa);

        randomSayi = (int)(Math.random()*101);
        buttonTahmin = findViewById(R.id.button2);
        kalanHak = findViewById(R.id.textView3);
        kalanHak.setText("Kalan Hak: 5");
        yonlendir = findViewById(R.id.textView4);
        tahmin = findViewById(R.id.editTextTextPersonName);

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac -= 1;
                gelenTahmin = Integer.parseInt(tahmin.getText().toString());

                if( gelenTahmin < randomSayi)
                    yonlendir.setText("ARTTIR");

                else if(gelenTahmin > randomSayi)
                    yonlendir.setText("AZALT");
                else {
                    Intent gecis = new Intent(getApplicationContext(), OyunSonuc.class);
                    gecis.putExtra("sonuc",true);
                    startActivity(gecis);
                    finish();
                    return;
                }

                if (sayac == 0) {
                    Intent gecis = new Intent(getApplicationContext(), OyunSonuc.class);
                    gecis.putExtra("sonuc",false);
                    gecis.putExtra("sayi",randomSayi);
                    startActivity(gecis);
                    finish();
                    return;
                }

                kalanHak.setText("Kalan Hak: "+ sayac);
                tahmin.setText("");

            }
        });
    }
}