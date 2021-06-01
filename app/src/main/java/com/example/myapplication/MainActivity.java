package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Pokemon;
import com.example.myapplication.database.PokemonDao;
import com.example.myapplication.repositories.PokemonRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.nio.MappedByteBuffer;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static AppDatabase db;
    static PokemonDao dao;
    static PokemonRepository repo;

    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private List<Pokemon> pokemons;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);
        dao = db.pokemonDao();
        repo = new PokemonRepository(dao);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);

        pokemons = repo.getAll();

        adapter = new MyAdapter(pokemons, R.layout.item_view, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon p, int position) {
                //UPDATE
            }
        });
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repo.insert(new Pokemon("Pikachu", "Electrico"));
                pokemons = repo.getAll();
                adapter.setPokemons(pokemons);
                //adapter.notifyDataSetChanged();
            }
        });
    }
    protected void onStart(){
        super.onStart();
        pokemons = repo.getAll();
        adapter.setPokemons(pokemons);
    }
}