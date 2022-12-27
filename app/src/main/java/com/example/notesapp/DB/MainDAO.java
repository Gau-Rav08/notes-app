package com.example.notesapp.DB;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesapp.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes WHERE pinned = 0 AND hidden = 0 ORDER BY id DESC")
    List<Notes> getAll();

//    @Query("SELECT * FROM notes WHERE hidden = 1 ORDER BY id DESC")
//    List<Notes> getHidden();

    @Query("SELECT * FROM notes WHERE pinned = 1 AND hidden = 0 ORDER BY id DESC")
    List<Notes> getPinned();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE id = :id")
    void update(int id, String title, String notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned = :pin WHERE id = :id")
    void pin(int id, boolean pin);



}