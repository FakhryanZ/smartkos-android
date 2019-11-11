package com.polinema.smartkos.data.pengeluaran;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pengeluaran")
public class Pengeluaran  {

    @PrimaryKey(autoGenerate = true)
    private int idPengeluaran;

    private String jenisPengeluaran;

    private int biaya;

    private String tanggal;

    public Pengeluaran(String jenisPengeluaran, int biaya) {
        this.jenisPengeluaran = jenisPengeluaran;
        this.biaya = biaya;
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
