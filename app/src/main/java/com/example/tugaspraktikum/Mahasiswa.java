package com.example.tugaspraktikum;

public class Mahasiswa {

    int _id;
    String _nim;
    String _nama;
    String _jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this._nama = nama;
        this._nim = nim;
        this._jurusan = jurusan;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
