package com.example.brendon.twitter_time_line.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;



import com.example.brendon.twitter_time_line.R;
import com.example.brendon.twitter_time_line.models.Twitte;

import java.util.List;

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.TweetViewHolder> {

    Context context;
    List<Twitte> twitts;

    public TwitterAdapter(Context context, List<Twitte> twitts) {
        this.twitts = twitts;
        this.context = context;
    }


    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_twittado, viewGroup, false);
        return new TweetViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final TweetViewHolder holder, int position) {

        Twitte twetteAtual = this.twitts.get(position);

        holder.txtNome.setText(twetteAtual.getNome());
        holder.txtLogin.setText(twetteAtual.getLogin());
        holder.txtDescricao.setText(twetteAtual.getDescricao());
        holder.txtData.setText(twetteAtual.getData());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Você clicou no Tweet de " + holder.txtLogin.getText(), Snackbar.LENGTH_LONG).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                final PopupMenu menupop = new PopupMenu(TwitterAdapter.this.context, view);
                menupop.getMenu().add("Curtir").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Snackbar.make(view ,"Curtido com sucesso!", Snackbar.LENGTH_LONG).show();

                        return false;
                    }
                });
                menupop.getMenu().add("Retwittar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Snackbar.make(view,"Retwittado com sucesso!", Snackbar.LENGTH_LONG).show();
                        return false;
                    }
                });
                menupop.show();

                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.twitts.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtLogin, txtDescricao, txtData;

        public TweetViewHolder(View view) {
            super(view);
            txtNome = view.findViewById(R.id.txt_nome);
            txtLogin = view.findViewById(R.id.txt_login);
            txtDescricao = view.findViewById(R.id.txt_descricao);
            txtData = view.findViewById(R.id.txt_data);
        }
    }
}
