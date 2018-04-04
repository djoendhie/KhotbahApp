package com.kun.jun.khotbahapp.model;

/**
 * Created by Jun on 3/28/2018.
 */

public class Khotbah {
    private String url;
    private String isi;
    private String id_khotba;
    private String judul;
    private String tanggal;

    public Khotbah(String id, String judul, String url, String isi, String tanggal) {
        this.id_khotba =id;
        this.judul = judul;
        this.url=url;
        this.isi=isi;
        this.tanggal = tanggal;
    }
    public Khotbah() {
        id_khotba="";
        judul="";
        url="";
        tanggal="";
        isi="";


    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getId_khotba() {
        return id_khotba;
    }

    public void setId_khotba(String id_khotba) {
        this.id_khotba = id_khotba;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

//    public void setUrl(Context context, String url) {
//    }
}
