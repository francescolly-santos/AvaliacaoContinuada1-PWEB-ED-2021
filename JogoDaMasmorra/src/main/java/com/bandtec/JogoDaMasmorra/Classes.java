package com.bandtec.JogoDaMasmorra;

public abstract class Classes implements Dano {
    // Foram utilizadas uma classe abstrata para servir de base para os personagens das classes (contexto do jogo)
    // "Mago" e "Guerreiro" junto com uma interface com cálculos de dano para ser implementada em todas
    // as classes (programação) (Guerreiro, Mago e Pet), pet é uma classe que não herda de "Classes"
    // pois no contexto do jogo o Pet tem somente nome e pontos
    // de ataque e não é em si uma classe jogável e diferentemente das
    // outras classes ela não "toma dano" mas ainda "ataca".

    // Classes estão sendo específicadas como classe (contexto do jogo) e classe (programação) para mais fácil
    // entendimento.

    private String nome;
    private Integer pontosDeVida;
    private Integer pontosAtaque;
    private Integer pontosVelocidade;

    public Classes(String nome, Integer pontosDeVida, Integer pontosAtaque, Integer pontosVelocidade) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.pontosAtaque = pontosAtaque;
        this.pontosVelocidade = pontosVelocidade;
    }

    public abstract String gritoDeGuerra();
    public abstract String fugir();

    public String getNome() {
        return nome;
    }

    public Integer getPontosDeVida() {
        return pontosDeVida;
    }

    public Integer getPontosAtaque() {
        return pontosAtaque;
    }

    public Integer getPontosVelocidade() {
        return pontosVelocidade;
    }

    public void setPontosDeVida(Integer pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "nome='" + nome + '\'' +
                ", pontosDeVida=" + pontosDeVida +
                ", pontosAtaque=" + pontosAtaque +
                ", pontosVelocidade=" + pontosVelocidade +
                '}';
    }
}
