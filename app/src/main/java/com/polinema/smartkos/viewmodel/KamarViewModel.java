package com.polinema.smartkos.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.polinema.smartkos.data.kamar.Kamar;
import com.polinema.smartkos.data.repository.KamarRepository;

import java.util.List;

public class KamarViewModel extends AndroidViewModel {
    private KamarRepository repository;
    private LiveData<List<Kamar>> kamarKosong;

    public KamarViewModel(@NonNull Application application) {
        super(application);
        repository = new KamarRepository(application);
        kamarKosong = repository.getKamarKosong();
    }

    public void insert(Kamar kamar){
        repository.insert(kamar);
    }

    public void update(Kamar kamar){
        repository.update(kamar);
    }

    public void delete(Kamar kamar){
        repository.delete(kamar);
    }

    public LiveData<List<Kamar>> getKamarKosong(){
        return kamarKosong;
    }
}
