package com.example.brendon.twitter_time_line;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.brendon.twitter_time_line.adapters.TwitterAdapter;
import com.example.brendon.twitter_time_line.dal.App;
import com.example.brendon.twitter_time_line.models.Twitte;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class Home_time_line_Activity extends AppCompatActivity {
    private RecyclerView item_twittado;
    Box<Twitte> boxTwittes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_time_line_);


        boxTwittes = ((App)getApplication()).getBoxStore().boxFor(Twitte.class);

        item_twittado = findViewById(R.id.list_twittes);

        TwitterAdapter adapter = new TwitterAdapter(this, getTwittadas());
        item_twittado.setAdapter(adapter);
        item_twittado.setLayoutManager(new LinearLayoutManager(this));





    }
    private List<Twitte> getTwittadas(){

        List<Twitte> twittadas = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            twittadas.add(new Twitte("Carlito","@Carlitinho","Hoje eu estava" +
                    "de boa na minha e encontrei um....","20/12/2018"));

            twittadas.add(new Twitte("Zuleide","@zuleides2","O que finalmente eu mais sei sobre" +
                    " a moral e as obrigações do homem devo ao futebol...","20/12/2018"));

            twittadas.add(new Twitte("Twitter Moments Brasil","@@MomentsBrasil","O Real Madrid venceu " +
                    "o Al Ain com facilidade por 4 a 1 e é o grande campeão do Mundial de Clubes da Fifa.","20/02/2018"));

            twittadas.add(new Twitte("Carlito","@Carlitinho","Creio que tenho prova " +
                    "suficiente de que falo a verdade: a pobreza.","22/12/2018"));
        }
        return twittadas;
    }
}





