package com.bandtec.JogoDaMasmorra;

import java.util.Random;

public class Mago extends Classes {
    Integer vida = getPontosDeVida();
    Random random = new Random();
    private String armaDeMago;


    public Mago(String nome,
                Integer pontosDeVida,
                Integer pontosAtaque,
                Integer pontosVelocidade,
                String armaDeMago) {
        super(nome, pontosDeVida, pontosAtaque, pontosVelocidade);
        this.armaDeMago = armaDeMago;
    }

    @Override
    public String gritoDeGuerra() {
        return "Avante comigo magia profunda, eu " + getNome() + " as dominarei," +
                " junto de minha arma  " + armaDeMago; }

    @Override
    public String atacar() {
        Integer ataque = getPontosAtaque() + random.nextInt(20);
        if (vida > 0) { Integer dano = random.nextInt(5);
            vida -= dano;
            if (vida < 0) { return "O mago " + getNome() + " infelizmente pereceu. F for respect."; }
            return "O mago após a batalha causou " + ataque + " pontos de" +
                    " dano e sofreu " + dano + " de dano" + " ficando com uma vida de " + vida;
        } else { return "O mago " + getNome() + " infelizmente pereceu. F for respect."; } }

    @Override
    public String fugir() {
        Double fuga = Math.random() * (20 - 1) + 1 + getPontosVelocidade();
        if (fuga > 110) { return "Fugiu com sucesso"; }
        else { return "Não conseguiu fugir"; } }
}
