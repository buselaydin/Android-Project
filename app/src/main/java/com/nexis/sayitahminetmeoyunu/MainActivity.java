package com.nexis.sayitahminetmeoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtKalanHak, txtSonuc;
    private EditText ediTxtSayi;
    private String gelenDeger;
    private int kalanHak = 3, randomSayi;
    private Random rndNumber;
    private boolean tahminDogruMu = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = (TextView) findViewById(R.id.txtViewKalanHak);  //nesneleri xml ile bağladık
        txtSonuc = (TextView) findViewById(R.id.txtViewSonuc);
        ediTxtSayi = (EditText) findViewById(R.id.editTxtSayi);

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(9);  // 0 ile 4 arasında eeğer atar
        System.out.println("Random Sayi:" + randomSayi);
    }

    public void btnTahminEt(View v) {
        gelenDeger = ediTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger)) {
            if (kalanHak > 0 && tahminDogruMu == false) {
                if (gelenDeger.equals(String.valueOf(randomSayi))) {
                    sonucGoster("Tebrikler Doğru Tahmin Ettiniz.");
                    tahminDogruMu = true;
                } else {
                    txtSonuc.setText("Maalesef Yanlış Tahmin. " +
                            "Tekrar Sayı Giriniz.");
                    ediTxtSayi.setText(""); //edittext i sıfırlar.
                }
                kalanHak--;
                txtKalanHak.setText("Kalan Hak :" + kalanHak);

                if (kalanHak == 0 && tahminDogruMu == false) {
                    sonucGoster("Tahmin Hakkınız Bitti");
                    ediTxtSayi.setText(" ");   //oyun bitti kısmına düşmesi için boş değer atıp else e girmesini sağladık.
                }
            } else
                txtSonuc.setText(("Oyun Bitti."));
        } else
            txtSonuc.setText("Girilen Değer Boş olamaz.");

    }

    private void sonucGoster(String mesaj) {
        ediTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);
    }
}