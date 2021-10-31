package com.example.calisma2_zaroyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OyunSonuc extends AppCompatActivity {
    public Button tekrarOyna;
    public ImageView sonucSimge;
    public TextView sonucAciklama;
    public boolean gelenSonuc;
    public int gelenSayi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonuc);

        tekrarOyna = findViewById(R.id.button3);
        sonucSimge = findViewById(R.id.imageView2);
        sonucAciklama = findViewById(R.id.textView2);

        gelenSonuc = getIntent().getBooleanExtra("sonuc", false);
        gelenSayi = getIntent().getIntExtra("sayi", 0);


        if (gelenSonuc){
            sonucSimge.setImageResource(R.drawable.smiley_face);
            sonucAciklama.setText("KAZANDINIZ");
        }
        else{
            sonucSimge.setImageResource(R.drawable.sad_face);
            sonucAciklama.setText("KAYBETTİNİZ\n Bulamadığınız Sayı: " + gelenSayi);
        }

        tekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecis = new Intent(getApplicationContext(),OyunAnaSayfa.class);
                startActivity(gecis);
                finish();
            }
        });

    }
}