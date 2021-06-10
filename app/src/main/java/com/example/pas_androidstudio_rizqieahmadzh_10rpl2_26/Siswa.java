package com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26;

public class Siswa {
    private String nama;
    private String jenjang;
    private String nomor_hp;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String email;

    public Siswa(String nama, String jenjang, String nomor_hp, String email) {
        this.nama = nama;
        this.jenjang = jenjang;
        this.nomor_hp = nomor_hp;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getjenjang() {
        return jenjang;
    }
    public void setjenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getnomor_hp() {
        return nomor_hp;
    }
    public void setnomor_hp(String nomor_hp) {
        this.nomor_hp = nomor_hp;
    }
}
