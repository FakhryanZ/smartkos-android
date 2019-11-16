package com.polinema.smartkos.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.AppDatabase;
import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.data.kamar.KamarDao;

import java.util.List;

public class KamarRepository {
    private KamarDao kamarDao;
    private LiveData<List<Kamar>> kamarKosong;

    public KamarRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        kamarDao = database.kamarDao();
        kamarKosong = kamarDao.getKamarKosong();
    }

    public void insert(Kamar kamar){
        new InsertKamarAsyncTask(kamarDao).execute(kamar);
    }

    public void update(Kamar kamar){
        new UpdateKamarAsyncTask(kamarDao).execute(kamar);
    }

    public void delete(Kamar kamar){
        new DeleteKamarAsyncTask(kamarDao).execute(kamar);
    }

    public LiveData<List<Kamar>> getKamarKosong(){
        return getKamarKosong();
    }

    private static class InsertKamarAsyncTask extends AsyncTask<Kamar, Void, Void>{
        private KamarDao kamarDao;

        private InsertKamarAsyncTask(KamarDao kamarDao){
            this.kamarDao = kamarDao;
        }

        @Override
        protected Void doInBackground(Kamar... kamars) {
            kamarDao.insert(kamars[0]);
            return null;
        }
    }

    private static class UpdateKamarAsyncTask extends AsyncTask<Kamar, Void, Void>{
        private KamarDao kamarDao;

        private UpdateKamarAsyncTask(KamarDao kamarDao){
            this.kamarDao = kamarDao;
        }

        @Override
        protected Void doInBackground(Kamar... kamars) {
            kamarDao.update(kamars[0]);
            return null;
        }
    }

    private static class DeleteKamarAsyncTask extends AsyncTask<Kamar, Void, Void>{
        private KamarDao kamarDao;

        private DeleteKamarAsyncTask(KamarDao kamarDao){
            this.kamarDao = kamarDao;
        }

        @Override
        protected Void doInBackground(Kamar... kamars) {
            kamarDao.delete(kamars[0]);
            return null;
        }
    }
}
