package com.polinema.smartkos.data.kamar;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KamarDao {

    @Insert
    void insert(Kamar kamar);

    @Update
    void update(Kamar kamar);

    @Delete
    void delete(Kamar kamar);

    @Query("SELECT * FROM kamar_table WHERE status=0")
    LiveData<List<Kamar>> getKamarKosong();

    @Query("SELECT * FROM kamar_table ORDER BY idKamar ASC")
    LiveData<List<Kamar>> getAllKamar();
}
