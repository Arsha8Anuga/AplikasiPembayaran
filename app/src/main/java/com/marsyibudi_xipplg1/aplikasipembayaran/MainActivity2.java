package com.marsyibudi_xipplg1.aplikasipembayaran;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //actionbar
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);

        //toolbar
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView navbot = findViewById(R.id.navbot);
    
        //MAKANAN
        final CheckBox makanan1 = findViewById(R.id.honeygalicchickenrice);
        final CheckBox makanan2 = findViewById(R.id.beefburger);
        final CheckBox makanan3 = findViewById(R.id.regularfries);

        //MINUMAN
        final CheckBox minuman1 = findViewById(R.id.icecreamcone);
        final CheckBox minuman2 = findViewById(R.id.flurryoreo);
        final CheckBox minuman3 = findViewById(R.id.fantafloat);

        //JUMLAH MAKANAN
        final EditText jml_mkn1 = findViewById(R.id.jumlahhoneygarlicchickenrice);
        final EditText jml_mkn2 = findViewById(R.id.jumlahbeefburger);
        final EditText jml_mkn3 = findViewById(R.id.jumlahregulerfries);

        //JUMLAH MINUMAN
        final EditText jml_min1 = findViewById(R.id.jumlahicecreamcone);
        final EditText jml_min2 = findViewById(R.id.jumlahflurryoreo);
        final EditText jml_min3 = findViewById(R.id.jumlahfantafloat);
        Button btn = findViewById(R.id.submit);


        //HARGA MAKANAN
        final int harga_honeygalicchickenrice = 35000;
        final int harga_beefburger = 30000;
        final int harga_regularfries = 25000;

        //HARGA MINUMAN
        final int harga_icecreamcone = 10000;
        final int harga_flurryoreo = 18000;
        final int harga_fantafloat = 15000;

        //navbot
        BottomNavigationView bottomNavigationView = findViewById(R.id.navbot);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.menu:
                        selectedFragment = new bottom_sheet();
                        return true;
                    case R.id.kontak:
                        bottom_sheet fragmentBottomSheetFull = new bottom_sheet();
                        fragmentBottomSheetFull.show(getSupportFragmentManager(), fragmentBottomSheetFull.getTag());

                        return false;

                }
                return false;


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!makanan1.isChecked() && !makanan2.isChecked() && !makanan3.isChecked() && !minuman1.isChecked() && !minuman2.isChecked() && !minuman3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Silahkan Pilih Makanan dan Minuman", Toast.LENGTH_SHORT).show();
                } else {
                    String text = "";
                    int totOrder = 0;
                    int discount = 0;
                    if (makanan1.isChecked()) {
                        String hasil = "Honey Garlic Chicken Rice ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn1.getText()));
                        int cal = jml * harga_honeygalicchickenrice;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;

                    }
                    if (makanan2.isChecked()) {
                        String hasil = "Beef Burger ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn2.getText()));
                        int cal = jml * harga_beefburger;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (makanan3.isChecked()) {
                        String hasil = "Reguler Fries ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn3.getText()));
                        int cal = jml * harga_regularfries;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }

                    //MINUMAN

                    if (minuman1.isChecked()) {
                        String hasil = "Ice cREAM cORN ";
                        int jml = Integer.parseInt(String.valueOf(jml_min1.getText()));
                        int cal = jml * harga_icecreamcone;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (minuman2.isChecked()) {
                        String hasil = "Mcflurry ";
                        int jml = Integer.parseInt(String.valueOf(jml_min2.getText()));
                        int cal = jml * harga_flurryoreo;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (minuman3.isChecked()) {
                        String hasil = "fANTA flOAT ";
                        int jml = Integer.parseInt(String.valueOf(jml_min3.getText()));
                        int cal = jml * harga_fantafloat;
                        text += jml + "\t\t" + hasil + "\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }

                    final EditText date =  findViewById(R.id.tanggalpesan);
                    final EditText nama =  findViewById(R.id.inputname);


                    String tanggal = date.getText().toString();
                    String name = nama.getText().toString();

                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                    intent.putExtra("Coba", text);
                    intent.putExtra("Bayar", totOrder);
                    intent.putExtra("Discout", discount);
                    intent.putExtra("ewe", tanggal);
                    intent.putExtra("udin", name);
                    startActivity(intent);


                }
            }

        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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