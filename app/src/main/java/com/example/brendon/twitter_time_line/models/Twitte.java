package com.example.brendon.twitter_time_line.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Twitte {
    @Id
    public long id;

    public String nome;
    public String login;
    public String descricao;
    public String data;

    public Twitte (String nome, String login , String descricao , String data){
        this.nome = nome;
        this.login = login;
        this.descricao = descricao;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }
}
