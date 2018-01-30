package com.nuansa.uas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nuansa.uas.models.Berita;

public class UpdateBerita extends AppCompatActivity {
    EditText txtisiUpdate,txtkategoriUpdate,txtJudulUpdate;
    Button BtnUpdateBerita,btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_berita);
        Intent i = getIntent();
        final Long idBerita = i.getLongExtra("idBerita",0L);
        Berita detailBerita = Berita.findById(Berita.class,idBerita);
        BtnUpdateBerita = (Button) findViewById(R.id.btnUpdateBerita);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        txtisiUpdate = (EditText) findViewById(R.id.txtisiUpdate);
        txtkategoriUpdate = (EditText) findViewById(R.id.txtkategoriUpdate);
        txtJudulUpdate = (EditText) findViewById(R.id.txtJudulUpdate);

        txtJudulUpdate.setText(detailBerita.getJudul());
        txtkategoriUpdate.setText(detailBerita.getKategori());
        txtisiUpdate.setText(detailBerita.getIsi());

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Berita berita = Berita.findById(Berita.class, idBerita);
                Intent i = new Intent(v.getContext(), MainActivity.class);
                i.putExtra("BeritaId", berita.getId());
                v.getContext().startActivity(i);
            }
        });

        BtnUpdateBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Berita mBerita = Berita.findById(Berita.class,idBerita);
                mBerita.setJudul(txtJudulUpdate.getText().toString());
                mBerita.setKategori(txtkategoriUpdate.getText().toString());
                mBerita.setIsi(txtisiUpdate.getText().toString());
                mBerita.save();
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.LayoutUpdateB),
                        "Data Berhasil Diupdate", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });

    }
}
