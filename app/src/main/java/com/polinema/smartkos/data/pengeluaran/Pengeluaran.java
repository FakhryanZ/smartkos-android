package com.polinema.smartkos.data.pengeluaran;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pengeluaran")
public class Pengeluaran  {

    @PrimaryKey(autoGenerate = true)
    private int idPengeluaran;

    @ColumnInfo(name = "jenis")
    private String jenisPengeluaran;

    @ColumnInfo(name = "biaya")
    private int biaya;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    public Pengeluaran(String jenisPengeluaran, int biaya, String tanggal) {
        this.jenisPengeluaran = jenisPengeluaran;
        this.biaya = biaya;
        this.tanggal = tanggal;
    }

    public int getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(int idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    public String getJenisPengeluaran() {
        return jenisPengeluaran;
    }

    public void setJenisPengeluaran(String jenisPengeluaran) {
        this.jenisPengeluaran = jenisPengeluaran;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
