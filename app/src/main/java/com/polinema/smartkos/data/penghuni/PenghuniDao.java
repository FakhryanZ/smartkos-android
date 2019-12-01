package com.polinema.smartkos.data.penghuni;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PenghuniDao {
    @Query("SELECT * FROM penghuni_table")
    LiveData<List<Penghuni>> getAllPenghuni();

    @Insert
    void insert(Penghuni penghuni);

    @Delete
    void delete(Penghuni penghuni);

    @Update
    void update(Penghuni penghuni);

//    @Query("UPDATE penghuni_table SET tglHabis = :tgl_habis WHERE idPenghuni = :id")
//    void updateTglHabis(Date tgl_habis, int id);
}
