package com.bandtec.JogoDaMasmorra;
import java.util.Random;

public class Pet implements Dano {
    private String nome;
    private Integer pontosDeAtaque;

    Random random = new Random();

    public Pet(String nome, Integer pontosDeAtaque) {
        this.nome = nome;
        this.pontosDeAtaque = pontosDeAtaque;
    }

    @Override
    public String atacar() {
        Integer ataque = pontosDeAtaque + random.nextInt(20);
        return "O pet após a batalha causou " + ataque + " pontos de dano ";
    }
}
