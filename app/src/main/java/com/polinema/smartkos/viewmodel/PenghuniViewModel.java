package com.polinema.smartkos.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.penghuni.Penghuni;
import com.polinema.smartkos.data.repository.PenghuniRepository;

import java.util.List;

public class PenghuniViewModel extends AndroidViewModel {
    private PenghuniRepository repository;
    private LiveData<List<Penghuni>> getAllPenghuni;


    public PenghuniViewModel(@NonNull Application application) {
        super(application);
        repository = new PenghuniRepository(application);
        getAllPenghuni = repository.getAllPenghuni();
    }

    public void insert(Penghuni penghuni){
        repository.insert(penghuni);
    }

    public void update(Penghuni penghuni){
        repository.update(penghuni);
    }

    public void delete(Penghuni penghuni){
        repository.delete(penghuni);
    }

    public LiveData<List<Penghuni>> getAllPenghuni(){
        return getAllPenghuni;
    }
}
