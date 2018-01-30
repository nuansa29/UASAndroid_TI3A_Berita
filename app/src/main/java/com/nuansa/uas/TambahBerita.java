package com.nuansa.uas;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nuansa.uas.models.Berita;

public class TambahBerita extends AppCompatActivity {
    EditText txtisi,txtkategori,txtJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_berita);
        Button btnSimpanberita = (Button) findViewById(R.id.btnSimpanBerita);
        txtisi = (EditText) findViewById(R.id.txtisi); //inisiasi layout
        txtkategori = (EditText) findViewById(R.id.txtkategori);
        txtJudul = (EditText) findViewById(R.id.txtJudul);
        txtJudul.requestFocus(); // klo kosong keluar error, jika ada 2 yg terakhir didahulukan
        btnSimpanberita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Berita mBerita = new Berita(txtJudul.getText().toString(),txtkategori.getText().toString(),txtisi.getText().toString());
                mBerita.save();
                txtisi.setText("");
                txtkategori.setText("");
                txtJudul.setText("");
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.constraintLayout),
                        "Data Berhasil Disimpan", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });
     }
}
