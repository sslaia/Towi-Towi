package com.blogspot.sslaia.towitowi.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TowiDao {

    @Insert
    void insert(Towi towi);

    @Update
    void update(Towi towi);

    @Delete
    void delete(Towi towi);

    @Query("DELETE FROM towi_table")
    void deleteAllTowies();

    @Query("SELECT * FROM towi_table ORDER BY id DESC")
    LiveData<List<Towi>> getAllTowies();
}
