package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PokemonDao {
    @Query("SELECT * FROM Pokemon")
    public List<Pokemon> getAll();

    @Insert
    public void insert(Pokemon p);

    @Update
    public void update(Pokemon p);

    @Delete
    public void delete(Pokemon p);

    @Query("SELECT * FROM Pokemon WHERE id_pokemon = :idPokemon")
    public Pokemon findById(int idPokemon);

    @Query("DELETE FROM Pokemon")
    public void deleteAll();
}
