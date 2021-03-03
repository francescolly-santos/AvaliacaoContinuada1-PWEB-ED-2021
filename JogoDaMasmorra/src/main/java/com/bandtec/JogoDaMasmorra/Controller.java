package com.bandtec.JogoDaMasmorra;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/iniciarMasmorra")
public class Controller {
    private List<Dano> listaPersonagens = new ArrayList<>();
    private List<Dano> listaPet = new ArrayList<>();

    //Variável para método validação do método Get
    Integer acesso = 0;

    Random random = new Random();

    //Objeto do tipo "Guerreiro" para uso dos métodos.
    private Guerreiro guerreiro = new Guerreiro(
            "Olaf (Guerreiro)",
            20,
            15,
            100,
            "Dente de tigre"
    );

    //Objeto do tipo "Mago" para uso dos métodos.
    private Mago mago = new Mago(
            "Merlin (Mago)",
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

    //Endpoint da tela inicial
    @GetMapping
    public String inicio(){
        return "Bem vindo ao Jogos da Masmorra, aqui você pode simular o uso de personagens guerreiro e magos, " +
                "ver informações sobres seus pets. Lista dos personagens disponível com endpoints específicos.\n" +
                "Use os comandos da seguinte forma (Exemplo) -> localhost:8080/IniciarMasmorra/Guerreiro/Atacar \n" +
                "Você pode trocar guerreiro por mago ou por pet, e trocar Atacar por Grito ou Fugir (O pet somente" +
                " ataca)."; }

    //Endpoints da lista de personagens (Exceto o mago e guerreiro intânciado).
    //Endpoints
    @GetMapping("/meusPersonagens")
    public List<Dano> personagens() {
        if (acesso == 0) {
            this.listaPersonagens.add(guerreiro);
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
            this.listaPersonagens.add(mago);
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
            acesso+=1;
            return this.listaPersonagens;
        } else{
            return this.listaPersonagens;
        }
    }
    //Endpoints para buscar objeto por posição.
    @GetMapping("/meusPersonagens/{posicao}")
    public Dano recuperar(@PathVariable int posicao) {
        if (this.listaPersonagens.size() > posicao) {
            return this.listaPersonagens.get(posicao);
        } else {
            return null;
        }
    }

    @DeleteMapping("/apagarPersonagem/{posicao}")
    public String deletePersonagem(@PathVariable int posicao){
        if(posicao < listaPersonagens.size()){
            listaPersonagens.remove(posicao);
            return "Personagem excluido com sucesso.";
        }else{
            return "Personagem não encontrado.";    
        }
    }

    //Endpoints do guerreiro.
    @GetMapping("/guerreiro")
    public Guerreiro guerreiroInfo(){
        return guerreiro;
    }

    @GetMapping("/guerreiro/{acao}")
    public String guerreiroAcao(@PathVariable String acao) {
        if(acao.equals("atacar")) {
            return guerreiro.atacar();
        }else if(acao.equals("gritar")){
            return guerreiro.gritoDeGuerra();
        }else if(acao.equals("fugir")){
            return guerreiro.fugir();
        }else{
            return "Não é uma ação válida.";
        }
    }

    //Endpoints do mago.
    @GetMapping("/mago")
    public Mago magoInfo(){
        return mago;
    }

    @GetMapping("/mago/{acao}")
    public String magoAcao(@PathVariable String acao) {
        if(acao.equals("atacar")) {
            return mago.atacar();
        }else if(acao.equals("gritar")){
            return mago.gritoDeGuerra();
        }else if(acao.equals("fugir")){
            return mago.fugir();
        }else{
            return "Não é uma ação válida.";
        }
    }

    //Endpoints do pet.
    @GetMapping("/pet/atacar")
    public String petAtaque() { return pet.atacar(); }
}
