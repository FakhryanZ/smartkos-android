package com.polinema.smartkos.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.data.kamar.KamarDao;
import com.polinema.smartkos.data.pengeluaran.Pengeluaran;
import com.polinema.smartkos.data.pengeluaran.PengeluaranDao;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.data.penghuni.PenghuniDao;

@Database(entities = {Kamar.class, Penghuni.class, Pengeluaran.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase instance;

    public abstract KamarDao kamarDao();
    public abstract PenghuniDao penghuniDao();


    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "smartkos.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public abstract PengeluaranDao pengeluaranDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private KamarDao kamarDao;

        PopulateDbAsyncTask(AppDatabase db){
            kamarDao = db.kamarDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            kamarDao.insert(new Kamar("A1", 1));
            kamarDao.insert(new Kamar("A2", 1));
            kamarDao.insert(new Kamar("A3", 1));
            return null;
        }
    }
}
