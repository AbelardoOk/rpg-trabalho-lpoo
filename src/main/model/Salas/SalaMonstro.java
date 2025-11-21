package src.main.model.Salas;

import src.main.model.Entidade.Monstro.Monstro;
import src.main.model.Entidade.Personagem.Personagem;

public class SalaMonstro extends Sala{

    public void entrouSala(Personagem heroi){

    }
    public Monstro criar_monstro(Personagem heroi){
        /* ao entrar na sala a experecia ascrescentada caso ganhe a luta é do nível +2
        se o  nível é multiplo de 3 o nível de expericiencia é multiplicado pelo nível da dificuldade
        do monstro*/
        int experiencia= heroi.getNivel()+2;

        if(heroi.getNivel()%3==0){ 
            experiencia*=3; 
        }
 
        // Antes era Monstro inimigo = new Monstro("Gollum", heroi.getNivel());
        Monstro inimigo = new Monstro( experiencia);

        return inimigo;

    }
    
}
