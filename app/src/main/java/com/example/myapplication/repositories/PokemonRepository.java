package com.example.myapplication.repositories;

import com.example.myapplication.database.Pokemon;
import com.example.myapplication.database.PokemonDao;

import java.util.List;

public class PokemonRepository {

    PokemonDao dao;

    public PokemonRepository(PokemonDao dao){
        this.dao = dao;
    }

    public List<Pokemon> getAll(){
        return dao.getAll();
    }

    public void insert(Pokemon p){dao.insert(p);}
    public void update(Pokemon p){dao.update(p);}
    public void delete(Pokemon p){dao.delete(p);}
    public Pokemon findById(int idPokemon){return dao.findById(idPokemon);}
    public void deleteAll(){dao.deleteAll();}


}
