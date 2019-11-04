package com.polinema.smartkos.data.penghuni;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PenghuniDao {
    @Query("SELECT * FROM penghuni")
    List<Penghuni> getAll();

    @Insert
    void insert(Penghuni... penghunis);

    @Delete
    void delete(Penghuni... penghunis);

    @Update
    void update(Penghuni... penghunis);
}
