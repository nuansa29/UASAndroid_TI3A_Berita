package com.nuansa.uas.models;

import com.orm.SugarRecord;


public class Berita extends SugarRecord<Berita>{
    public String judul;
    public String kategori;
    public String isi;

    public Berita(String judul, String kategori, String isi) {
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
    }

    public Berita() {
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
