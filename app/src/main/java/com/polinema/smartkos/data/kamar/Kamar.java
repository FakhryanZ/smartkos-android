package com.polinema.smartkos.data.kamar;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kamar")
public class Kamar {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idKamar")
    public int idKamar;

    @ColumnInfo(name = "noKamar")
    public String noKamar;

    @ColumnInfo(name = "status")
    public String status;
}
