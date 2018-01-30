package com.nuansa.uas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nuansa.uas.models.Berita;

public class DetailBerita extends AppCompatActivity {
    TextView judulBerita,kategoriBerita,isiBerita;
    Button buttonDelete,buttonUpdate,buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        Intent i = getIntent();
        final Long idBerita = i.getLongExtra("BeritaId",0L);
        Berita detailBerita = Berita.findById(Berita.class,idBerita);
        judulBerita = (TextView) findViewById(R.id.judulBerita);
        judulBerita.setText(detailBerita.getJudul());
        kategoriBerita = (TextView) findViewById(R.id.kategoriBerita);
        kategoriBerita.setText(detailBerita.getKategori());
        isiBerita = (TextView) findViewById(R.id.isiBerita);
        isiBerita.setText(detailBerita.getIsi());

        buttonDelete = (Button) findViewById(R.id.btnDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Berita berita = Berita.findById(Berita.class, idBerita);
                berita.delete();
                Intent i = new Intent(v.getContext(),DaftarBerita.class);
                v.getContext().startActivity(i);
            }
        });

        buttonKembali = (Button) findViewById(R.id.btnKembaliBerita);
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DaftarBerita.class);
                v.getContext().startActivity(i);
            }
        });

        buttonUpdate = (Button) findViewById(R.id.btnUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Berita berita = Berita.findById(Berita.class, idBerita);
                Intent i = new Intent(v.getContext(),UpdateBerita.class);
                i.putExtra("idBerita", berita.getId());
                v.getContext().startActivity(i);
            }
        });


    }
}
