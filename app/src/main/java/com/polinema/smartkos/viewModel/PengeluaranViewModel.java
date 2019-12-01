package com.polinema.smartkos.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.pengeluaran.Pengeluaran;
import com.polinema.smartkos.data.repository.PengeluaranRepository;

import java.util.List;

public class PengeluaranViewModel extends AndroidViewModel {
    private PengeluaranRepository repository;
    private LiveData<List<Pengeluaran>> allPengeluaran;

    public PengeluaranViewModel(@NonNull Application application) {
        super(application);
        repository = new PengeluaranRepository(application);
        allPengeluaran = repository.getAllPengeluaran();
    }

    public void insert(Pengeluaran pengeluaran) {
        repository.insert(pengeluaran);
    }

    public void update(Pengeluaran pengeluaran) {
        repository.update(pengeluaran);
    }

    public void delete(Pengeluaran pengeluaran) {
        repository.delete(pengeluaran);
    }

    public LiveData<List<Pengeluaran>> getAllPengeluaran() {
        return allPengeluaran;
    }
}
