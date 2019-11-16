package com.polinema.smartkos.data.penghuni;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "penghuni_table")
public class Penghuni {
    @PrimaryKey(autoGenerate = true)
    public int idPenghuni;

    public String nama;

    public String noHp;

    public String noKtp;

    public String tglMasuk;

    public String  idKamar;

    public Penghuni(String nama, String noHp, String noKtp, String tglMasuk, String idKamar) {
        this.nama = nama;
        this.noHp = noHp;
        this.noKtp = noKtp;
        this.tglMasuk = tglMasuk;
        this.idKamar = idKamar;
    }

    public int getIdPenghuni() {
        return idPenghuni;
    }

    public void setIdPenghuni(int idPenghuni) {
        this.idPenghuni = idPenghuni;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(String idKamar) {
        this.idKamar = idKamar;
    }
}
