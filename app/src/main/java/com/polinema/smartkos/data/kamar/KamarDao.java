package com.polinema.smartkos.data.kamar;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KamarDao {
    @Query("SELECT * FROM kamar")
    List<Kamar> getAll();

    @Query("SELECT * FROM KAMAR LIMIT 1")
    Kamar selectOne();

    @Insert
    void insertAll(Kamar... kamars);

    @Delete
    void delete(Kamar... kamar);

    @Update
    void update(Kamar... kamar);
}
