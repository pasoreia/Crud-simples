package com.example.model;

public class Usuario{
    
    private String nome;
    private int id;
    private String email;
    private int senha;




    public Usuario(String nome, String email,  int senha) {
        this.email = email;
        //this.id = id;
        this.nome = nome;
        this.senha = senha;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }



    
}