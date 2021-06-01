package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pokemon")
public class Pokemon {
    @PrimaryKey(autoGenerate = true) //sin ';'
    @ColumnInfo(name = "id_pokemon") //sin ';'
    private int idPokemon;
    private String nombre;
    private String tipo;

    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
