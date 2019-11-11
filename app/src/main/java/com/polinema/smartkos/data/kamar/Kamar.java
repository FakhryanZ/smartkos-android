package com.polinema.smartkos.data.kamar;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kamar_table")
public class Kamar {
    @PrimaryKey(autoGenerate = true)
    public int idKamar;

    public String noKamar;


    public String status;

    public Kamar(String noKamar, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
