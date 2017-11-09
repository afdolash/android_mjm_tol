package com.codesch.afdolash.mjmtol.model;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class Product {
    private int id_produk;
    private String nama_produk;
    private int harga_produk;
    private String deskripsi_produk;
    private String foto_produk;
    private int id_umkm;

    public Product(int id_produk, String nama_produk, int harga_produk, String deskripsi_produk, String foto_produk, int id_umkm) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.foto_produk = foto_produk;
        this.id_umkm = id_umkm;
    }

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

    public int getId_umkm() {
        return id_umkm;
    }
}
