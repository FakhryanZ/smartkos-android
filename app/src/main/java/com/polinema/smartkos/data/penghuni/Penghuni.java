package com.polinema.smartkos.data.penghuni;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "penghuni")
public class Penghuni {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idPenghuni")
    public int idPenghuni;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "noHp")
    public String noHp;

    @ColumnInfo(name = "noKtp")
    public String noKtp;

    @ColumnInfo(name = "tglMasuk")
    public Date tglMasuk;

    @ColumnInfo(name = "tglHabis")
    public Date tglHabis;

    @ColumnInfo(name = "idKamar")
    public int idKamar;

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

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Date getTglHabis() {
        return tglHabis;
    }

    public void setTglHabis(Date tglHabis) {
        this.tglHabis = tglHabis;
    }

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }
}
