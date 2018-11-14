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

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    Context mContext;
    List<Filme> filmes;

    public FilmeAdapter(Context context) {
        this.mContext = context;
        filmes = new ArrayList<>();
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

        Picasso.get().load(new File(filme.path)).into(holder.filmeimage);
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
            intent.putExtra("filme_name", filme.getName());
            intent.putExtra("filme_description", filme.getDescription());
            //intent.putExtra("filme_image",filme.getRes());
            //mContext.startActivity(intent);
        }
    }

}
