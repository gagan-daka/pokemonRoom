package com.example.myapplication;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.Pokemon;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Pokemon> pokemons;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapter(List<Pokemon> pokemons, int layout, OnItemClickListener itemClickListener) {
        this.pokemons = pokemons;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }



    public void setPokemons(List<Pokemon> pokemons){
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(this.pokemons.get(position), (OnItemClickListener) this.itemClickListener);
    }

    @Override
    public int getItemCount() {
        return this.pokemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNom;
        public TextView textViewTipo;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            this.textViewNom = itemView.findViewById(R.id.textViewNom);
            this.textViewTipo = itemView.findViewById(R.id.textViewTipo);
        }
        public void bind(final Pokemon p, final OnItemClickListener itemClickListener){
            this.textViewNom.setText(p.getNombre());
            this.textViewTipo.setText(p.getTipo());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(p, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Pokemon p, int position);
    }


}
