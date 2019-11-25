package com.polinema.smartkos.data.kamar;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kamar_table")
public class Kamar {
    @PrimaryKey(autoGenerate = true)
    public int idKamar;

    public String noKamar;

    public int status;

    public Kamar(String noKamar, int status) {
        this.noKamar = noKamar;
        this.status = status;
    }

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString() {
        return noKamar;
    }
}
