package com.jovanyguiagmail.myapplication;

import android.content.Context;
import android.content.Intent;
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
        filmes.add(new Filme(R.drawable.interstellar, "interstellar", "uma capa do filme interstellar"));
        filmes.add(new Filme(R.drawable.freestateofjones, "free state of jones", "uma capa do filme free state of jones"));
        filmes.add(new Filme(R.drawable.gonegirl, "gone girl", "uma capa do filme gone girl"));
        filmes.add(new Filme(R.drawable.straightouttacompton, "straight outta compton", "capa do filme straight outta compton"));
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FilmeViewHolder holder, int position) {
        final Filme filme = filmes.get(position);
        holder.filmeimage.setImageResource(filme.getRes());
        holder.filmename.setText(filme.getName());
        holder.filmedescription.setText(filme.getDescription());
        holder.filmeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.openActivity(filme);
            }
        });
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

        public void openActivity(Filme filme) {
            Intent intent = new Intent(mContext, FilmeActivity.class);
            intent.putExtra("filme_image", filme.res);
            intent.putExtra("filme_description", filme.getDescription());
            intent.putExtra("filme_image",filme.getRes());
            mContext.startActivity(intent);
        }
    }

}
