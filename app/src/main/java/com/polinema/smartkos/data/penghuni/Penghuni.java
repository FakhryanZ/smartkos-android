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
}
