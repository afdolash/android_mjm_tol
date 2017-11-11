package com.codesch.afdolash.mjmtol.model;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class ProductDetail {
    private int id_produk;
    private String nama_produk;
    private int harga_produk;
    private String deskripsi_produk;
    private String foto_produk;
    private String kategori_produk;
    private Umkm id_umkm;

    public int getId_produk() {
        return id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public int getHarga_produk() {
        return harga_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public String getFoto_produk() {
        return foto_produk;
    }

    public String getKategori_produk() {
        return kategori_produk;
    }

    public Umkm getId_umkm() {
        return id_umkm;
    }
}
