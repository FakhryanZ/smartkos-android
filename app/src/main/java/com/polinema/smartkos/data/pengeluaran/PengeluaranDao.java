package com.polinema.smartkos.data.pengeluaran;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PengeluaranDao {

    @Insert
    void insert(Pengeluaran pengeluaran);

    @Update
    void update(Pengeluaran pengeluaran);

    @Delete
    void delete(Pengeluaran pengeluaran);

    @Query("SELECT * FROM Pengeluaran ORDER BY idPengeluaran ASC")
    LiveData<List<Pengeluaran>> getAllPengeluaran();

//    @Query("SELECT SUM(biaya) as valTotalMonth " +
//            "FROM Pengeluaran WHERE strftime('%Y', tanggal)= strftime('%Y', date('now')) AND strftime('%m',tanggal) = strftime('%m',date('now'))")
//    Pengeluaran getAllBiaya();
}
