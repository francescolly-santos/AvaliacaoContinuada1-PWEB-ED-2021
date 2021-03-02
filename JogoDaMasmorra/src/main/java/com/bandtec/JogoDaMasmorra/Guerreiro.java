package com.bandtec.JogoDaMasmorra;
import java.util.Random;

public class Guerreiro extends Classes {
    private String armaDeGuerreiro;

    Integer vida = getPontosDeVida();
    Random random = new Random();

    public Guerreiro(String nome,
                     Integer pontosDeVida,
                     Integer pontosAtaque,
                     Integer pontosVelocidade,
                     String armaDeGuerreiro) {
        super(nome, pontosDeVida, pontosAtaque, pontosVelocidade);
        this.armaDeGuerreiro = armaDeGuerreiro; }

    @Override
    public String gritoDeGuerra() {
        return "Avante comigo espíritos antigos, eu " + getNome() + " os honrarei," +
                " junto de minha arma  " + armaDeGuerreiro; }

    @Override
    public String atacar() {
        Integer ataque = getPontosAtaque() + random.nextInt(20);
        if (vida > 0) { Integer dano = random.nextInt(5);
            vida -= dano;
            if (vida < 0) { return "O guerreiro " + getNome() + " infelizmente pereceu. F for respect."; }
            return "O guerreiro após a batalha causou " + ataque + " pontos de" +
                    " dano e sofreu " + dano + " de dano" + " ficando com uma vida de " + vida;
        } else { return "O guerreiro " + getNome() + " infelizmente pereceu. F for respect."; } }

    @Override
    public String fugir() {
        Double fuga = Math.random() * (20 - 1) + 1 + getPontosVelocidade();
        if (fuga > 110) { return "Fugiu com sucesso, corra com tudo que puder."; }
        else { return "Não conseguiu fugir, simule a batalha novamente."; } }
}
