package com.polinema.smartkos.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.data.kamar.KamarDao;
import com.polinema.smartkos.data.pengeluaran.Pengeluaran;
import com.polinema.smartkos.data.pengeluaran.PengeluaranDao;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.data.penghuni.PenghuniDao;

@Database(entities = {Kamar.class, Penghuni.class, Pengeluaran.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract KamarDao kamarDao();
    public abstract PenghuniDao penghuniDao();
    public abstract PengeluaranDao pengeluaranDao();

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,"smartkos.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(RoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback RoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private PengeluaranDao pengeluaranDao;

        PopulateDbAsyncTask(AppDatabase db) {
            pengeluaranDao = db.pengeluaranDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
//            pengeluaranDao.insert(new Pengeluaran("Listrik & Air",0));
//            pengeluaranDao.insert(new Pengeluaran("WiFi",0));
//            pengeluaranDao.insert(new Pengeluaran("Kebersihan",0));
            return null;
        }
    }
}
