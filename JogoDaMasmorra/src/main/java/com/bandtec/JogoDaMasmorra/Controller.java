package com.bandtec.JogoDaMasmorra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/IniciarMasmorra")
public class Controller {
    private List<Dano> listaPersonagens = new ArrayList<>();

    Random random = new Random();

    //Objeto do tipo "Guerreiro" para uso dos métodos.
    private Guerreiro guerreiro = new Guerreiro(
            "Olaf",
            20,
            15,
            100,
            "Dente de tigre"
    );

    //Objeto do tipo "Mago" para uso dos métodos.
    private Mago mago = new Mago(
            "Merlin",
            10,
            30,
            95,
            "Eco de Luden"
    );
    //Objeto do tipo "Pet" para uso dos métodos.
    private Pet pet = new Pet(
            "Peeko",
            12
    );

    //Objetos da lista para trabalhar com os endpoints.
    public Controller() {
        this.listaPersonagens.add(new Guerreiro(
                "Andrew (Guerreiro)",
                20,
                20,
                101,
                "Sopro do Dragão")
        );
        this.listaPersonagens.add(new Guerreiro(
                "Jackson (Guerreiro)",
                16,
                18,
                103,
                "Força do vendaval")
        );
        this.listaPersonagens.add(new Mago(
                "Ganondorf (Mago)",
                13,
                31,
                96,
                "Brasa de Bami")
        );
        this.listaPersonagens.add(new Mago(
                "Patolino (Mago)",
                12,
                30,
                99,
                "Cajado de Rabadon")
        );

    }

    //Endpoint da tela inicial
    @GetMapping
    public String inicio(){
        return "Bem vindo ao Jogos da Masmorra, aqui você pode simular o uso de personagens guerreiro e magos, " +
                "ver informações sobres seus pets. Lista dos personagens disponível com endpoints específicos.\n" +
                "Use os comandos da seguinte forma (Exemplo) -> localhost:8080/IniciarMasmorra/Guerreiro/Atacar \n" +
                "Você pode trocar guerreiro por mago ou por pet, e trocar Atacar por Grito ou Fugir (O pet somente" +
                " ataca)."; }

    //Endpoints da lista de personagens (Exceto o mago e guerreiro intânciado).
    @GetMapping("/MeusPersonagens")
    public List<Dano> personagens() {
        return this.listaPersonagens; }

    @GetMapping("/MeusPersonagens/{posicao}")
    public Dano recuperar(@PathVariable int posicao) {
        if (this.listaPersonagens.size() > posicao) {
            return this.listaPersonagens.get(posicao);
        } else {
            return null;
        }
    }

    //Endpoints do guerreiro.
    @GetMapping("/Guerreiro/Atacar")
    public String guerreiroAtaque() {
        return guerreiro.atacar();
    }

    @GetMapping("/Guerreiro/Grito")
    public String guerreiroGrito() {
        return guerreiro.gritoDeGuerra();
    }

    @GetMapping("/Guerreiro/Fugir")
    public String guerreiroFuga() {
        return guerreiro.fugir();
    }

    //Endpoints do mago.
    @GetMapping("/Mago/Atacar")
    public String magoAtaque() {
        return mago.atacar();
    }

    @GetMapping("/Mago/Grito")
    public String magoGrito() {
        return mago.gritoDeGuerra();
    }

    @GetMapping("/Mago/Fugir")
    public String magoFuga() {
        return mago.fugir();
    }

    //Endpoints do pet.
    @GetMapping("/Pet/Atacar")
    public String petAtaque() { return pet.atacar();
    }

}
