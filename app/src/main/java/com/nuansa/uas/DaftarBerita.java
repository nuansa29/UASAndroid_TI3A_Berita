package com.nuansa.uas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.nuansa.uas.adapter.BeritaAdapter;
import com.nuansa.uas.models.Berita;

import java.util.ArrayList;
import java.util.List;

public class DaftarBerita extends AppCompatActivity {
    private BeritaAdapter mAdapter;
    private List<Berita> mDaftarBerita = new ArrayList<>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_berita);
        mDaftarBerita = Berita.listAll(Berita.class);

        RecyclerView recyclerBerita = (RecyclerView) findViewById(R.id.recyclerBerita);
        mAdapter = new BeritaAdapter(getApplicationContext(), mDaftarBerita);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerBerita.setLayoutManager(mLayoutManager);
        recyclerBerita.setItemAnimator(new DefaultItemAnimator());
        recyclerBerita.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}
