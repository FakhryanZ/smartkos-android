package com.polinema.smartkos.data.penghuni;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "penghuni_table")
public class Penghuni implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int idPenghuni;

    public String nama;

    public String noHp;

    public String noKtp;

    public Date tglMasuk;

    public Date tglHabis;

    public String  idKamar;

    public Penghuni(String nama, String noHp, String noKtp, Date tglMasuk, String idKamar, Date tglHabis) {
        this.nama = nama;
        this.noHp = noHp;
        this.noKtp = noKtp;
        this.tglMasuk = tglMasuk;
        this.idKamar = idKamar;
        this.tglHabis = tglHabis;
    }

    protected Penghuni(Parcel in) {
        idPenghuni = in.readInt();
        nama = in.readString();
        noHp = in.readString();
        noKtp = in.readString();
        idKamar = in.readString();
        tglMasuk = new Date(in.readLong());
        tglHabis = new Date(in.readLong());
    }

    public static final Creator<Penghuni> CREATOR = new Creator<Penghuni>() {
        @Override
        public Penghuni createFromParcel(Parcel in) {
            return new Penghuni(in);
        }

        @Override
        public Penghuni[] newArray(int size) {
            return new Penghuni[size];
        }
    };

    public Penghuni(Date tglHabis, int id) {
        this.tglHabis = tglHabis;
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

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(String idKamar) {
        this.idKamar = idKamar;
    }

    public Date getTglHabis() {
        return tglHabis;
    }

    public void setTglHabis(Date tglHabis) {
        this.tglHabis = tglHabis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idPenghuni);
        parcel.writeString(nama);
        parcel.writeString(noHp);
        parcel.writeString(noKtp);
        parcel.writeString(idKamar);
        parcel.writeLong(tglMasuk.getTime());
        parcel.writeLong(tglHabis.getTime());
    }
}
