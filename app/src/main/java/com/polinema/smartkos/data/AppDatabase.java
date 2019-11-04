package com.polinema.smartkos.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.data.kamar.KamarDao;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.data.penghuni.PenghuniDao;

@Database(entities = {Kamar.class, Penghuni.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract KamarDao kamarDao();
    public abstract PenghuniDao penghuniDao();
}
