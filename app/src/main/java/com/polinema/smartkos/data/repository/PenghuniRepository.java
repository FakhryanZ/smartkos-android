package com.polinema.smartkos.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.AppDatabase;
import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.data.penghuni.PenghuniDao;

import java.util.Date;
import java.util.List;

public class PenghuniRepository {
    private PenghuniDao penghuniDao;
    private LiveData<List<Penghuni>> allPenghuni;

    public PenghuniRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        penghuniDao = database.penghuniDao();
        allPenghuni = penghuniDao.getAllPenghuni();
    }

    public void insert(Penghuni penghuni){
        new InsertPenghuniAsyncTask(penghuniDao).execute(penghuni);
    }


    public void update(Penghuni penghuni){
        new UpdatePenghuniAsyncTask(penghuniDao).execute(penghuni);
    }

    public void delete(Penghuni penghuni){
        new DeletePenghuniAsyncTask(penghuniDao).execute(penghuni);
    }

    public void updateTglHabis(Date tglHabis, int id){
        Penghuni penghuni = new Penghuni(tglHabis,id);
        new UpdateTglHabisAsyncTask(penghuniDao).execute(penghuni);
    }

    public LiveData<List<Penghuni>> getAllPenghuni(){
        return allPenghuni;
    }

    private static class InsertPenghuniAsyncTask extends AsyncTask<Penghuni, Void, Void>{
        private PenghuniDao penghuniDao;

        private InsertPenghuniAsyncTask(PenghuniDao penghuniDao){
            this.penghuniDao = penghuniDao;
        }

        @Override
        protected Void doInBackground(Penghuni... penghunis) {
            penghuniDao.insert(penghunis[0]);
            return null;
        }
    }

    private static class UpdatePenghuniAsyncTask extends AsyncTask<Penghuni, Void, Void>{
        private PenghuniDao penghuniDao;

        private UpdatePenghuniAsyncTask(PenghuniDao penghuniDao){
            this.penghuniDao = penghuniDao;
        }

        @Override
        protected Void doInBackground(Penghuni... penghunis) {
            penghuniDao.update(penghunis[0]);
            return null;
        }
    }

    private static class UpdateTglHabisAsyncTask extends AsyncTask<Penghuni, Void, Void>{
        private PenghuniDao penghuniDao;

        private UpdateTglHabisAsyncTask(PenghuniDao penghuniDao){
            this.penghuniDao = penghuniDao;
        }

        @Override
        protected Void doInBackground(Penghuni... penghunis) {
//            Date tglHabis = penghunis[0].tglHabis;
//            int id = penghunis[0].idPenghuni;
//            penghuniDao.updateTglHabis(tglHabis,id);
            return null;
        }
    }

    private static class DeletePenghuniAsyncTask extends AsyncTask<Penghuni, Void, Void>{
        private PenghuniDao penghuniDao;

        private DeletePenghuniAsyncTask(PenghuniDao penghuniDao){
            this.penghuniDao = penghuniDao;
        }

        @Override
        protected Void doInBackground(Penghuni... penghunis) {
            penghuniDao.delete(penghunis[0]);
            return null;
        }
    }
}
