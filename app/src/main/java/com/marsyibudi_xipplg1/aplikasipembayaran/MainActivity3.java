package com.marsyibudi_xipplg1.aplikasipembayaran;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView text = findViewById(R.id.berhasil);
        TextView total1 = findViewById(R.id.total);
        TextView disc = findViewById(R.id.discount);
        TextView bel = findViewById(R.id.belanja);
        TextView nama = findViewById(R.id.nama);
        TextView tanggal = findViewById(R.id.tanggal);

        Intent intent = getIntent();
        String sum = intent.getStringExtra("Coba");
        int tot = intent.getIntExtra("Bayar", 0);
        String tanggall = intent.getStringExtra("ewe");
        String namaa = intent.getStringExtra("udin");
        int discount = 0;
        if (tot > 100000) {
            discount = 10000;
        }

        int belanja = tot - discount;

        text.setText(sum);
        tanggal.setText("time in \n" + tanggall);
        nama.setText("atas nama \n"+namaa);
        total1.setText("Rp. " + tot);
        disc.setText("RP. " + discount);
        bel.setText("Rp. " + belanja);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        //set pesan yang akan ditampilkan
        builder.setMessage("Anda Yakin Ingin Keluar ?");
        //set positive tombol jika menjawab ya
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika kalian menekan tombol ya, maka otomatis akan keluar dari activity saat ini
                finish();
            }
        });
        //set negative tombol jika menjawab tidak
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika menekan tombol tidak, maka kalian akan tetap berada di activity saat ini
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}