package com.jovanyguiagmail.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    Context mContext;
    List<Filme> filmes;

    public FilmeAdapter(Context context) {
        this.mContext = context;
        filmes = new ArrayList<>();
        filmes.add(new Filme(R.drawable.angola, "angola", "uma inagem de angola"));
        filmes.add(new Filme(R.drawable.losangles, "los angeles", "uma inagem de los angeles"));
        filmes.add(new Filme(R.drawable.esquilo, "esquilo", "uma inagem de esquilo"));
        filmes.add(new Filme(R.drawable.docker, "docker", "uma inagem do docker"));
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.filmeimage.setImageResource(filme.getRes());
        holder.filmename.setText(filme.getName());
        holder.filmedescription.setText(filme.getDescription());
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class FilmeViewHolder extends RecyclerView.ViewHolder {

        ImageView filmeimage;
        TextView filmename;
        TextView filmedescription;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            filmeimage = itemView.findViewById(R.id.filme_image);
            filmename = itemView.findViewById(R.id.filme_name);
            filmedescription = itemView.findViewById(R.id.filme_description);
        }
    }

}
