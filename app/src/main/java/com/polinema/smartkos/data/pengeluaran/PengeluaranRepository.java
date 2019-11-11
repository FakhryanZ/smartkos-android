package com.polinema.smartkos.data.pengeluaran;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.AppDatabase;

import java.util.List;

public class PengeluaranRepository {
    private PengeluaranDao pengeluaranDao;
    private LiveData<List<Pengeluaran>> allPengeluaran;

    public PengeluaranRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        pengeluaranDao = database.pengeluaranDao();
        allPengeluaran = pengeluaranDao.getAllPengeluaran();
    }

    public  void insert(Pengeluaran pengeluaran) {
        new InsertPengeluaranAsyncTask(pengeluaranDao).execute(pengeluaran);
    }

    public  void update(Pengeluaran pengeluaran) {
        new UpdatePengeluaranAsyncTask(pengeluaranDao).execute(pengeluaran);
    }

    public  void delete(Pengeluaran pengeluaran) {
        new DeletePengeluaranAsyncTask(pengeluaranDao).execute(pengeluaran);

    }

    public  LiveData<List<Pengeluaran>> getAllPengeluaran() {
        return allPengeluaran;
    }

    private static class InsertPengeluaranAsyncTask extends AsyncTask<Pengeluaran, Void, Void> {
        private PengeluaranDao pengeluaranDao;

        private InsertPengeluaranAsyncTask(PengeluaranDao pengeluaranDao) {
            this.pengeluaranDao = pengeluaranDao;
        }
        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.insert(pengeluarans[0]);
            return null;
        }
    }

    private static class UpdatePengeluaranAsyncTask extends AsyncTask<Pengeluaran, Void, Void> {
        private PengeluaranDao pengeluaranDao;

        private UpdatePengeluaranAsyncTask(PengeluaranDao pengeluaranDao) {
            this.pengeluaranDao = pengeluaranDao;
        }
        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.update(pengeluarans[0]);
            return null;
        }
    }

    private static class DeletePengeluaranAsyncTask extends AsyncTask<Pengeluaran, Void, Void> {
        private PengeluaranDao pengeluaranDao;

        private DeletePengeluaranAsyncTask(PengeluaranDao pengeluaranDao) {
            this.pengeluaranDao = pengeluaranDao;
        }
        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.delete(pengeluarans[0]);
            return null;
        }
    }
}
