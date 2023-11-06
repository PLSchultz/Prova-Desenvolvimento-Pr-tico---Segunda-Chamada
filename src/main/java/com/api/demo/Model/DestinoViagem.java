package com.api.demo.Model;

public class DestinoViagem {
    private Long id;
    private String nome;
    private String localizacao;
    private double avaliacao;

    public DestinoViagem() {
    }

    public DestinoViagem(Long id, String nome, String localizacao, double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.avaliacao = avaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "DestinoViagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}

