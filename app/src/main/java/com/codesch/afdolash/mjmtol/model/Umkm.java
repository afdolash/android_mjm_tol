package com.codesch.afdolash.mjmtol.model;

import java.sql.Time;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class Umkm {
    private int id_umkm;
    private String nama_umkm;
    private String kontak_umkm;
    private String foto_umkm;
    private String alamat_umkm;
    private double longitude_umkm;
    private double latitude_umkm;
    private String buka_umkm;
    private String tutup_umkm;
    private String keterangan_umkm;

    public Umkm(int id_umkm, String nama_umkm, String kontak_umkm, String foto_umkm, String alamat_umkm, double longitude_umkm, double latitude_umkm, String buka_umkm, String tutup_umkm, String keterangan_umkm) {
        this.id_umkm = id_umkm;
        this.nama_umkm = nama_umkm;
        this.kontak_umkm = kontak_umkm;
        this.foto_umkm = foto_umkm;
        this.alamat_umkm = alamat_umkm;
        this.longitude_umkm = longitude_umkm;
        this.latitude_umkm = latitude_umkm;
        this.buka_umkm = buka_umkm;
        this.tutup_umkm = tutup_umkm;
        this.keterangan_umkm = keterangan_umkm;
    }

    public int getId_umkm() {
        return id_umkm;
    }

    public String getNama_umkm() {
        return nama_umkm;
    }

    public String getKontak_umkm() {
        return kontak_umkm;
    }

    public String getFoto_umkm() {
        return foto_umkm;
    }

    public String getAlamat_umkm() {
        return alamat_umkm;
    }

    public double getLongitude_umkm() {
        return longitude_umkm;
    }

    public double getLatitude_umkm() {
        return latitude_umkm;
    }

    public String getBuka_umkm() {
        return buka_umkm;
    }

    public String getTutup_umkm() {
        return tutup_umkm;
    }

    public String getKeterangan_umkm() {
        return keterangan_umkm;
    }
}
