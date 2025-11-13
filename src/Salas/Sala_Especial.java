package src.Salas;

import java.util.Random;

import src.Entidade.Personagem.Personagem;

public class Sala_Especial {
    private float modificadorVida;

    public void setModificadorVida(float vida){
        this.modificadorVida+=vida;        
    }

    public Sala_Especial(){
        Random gerador= new Random();
        setModificadorVida(gerador.nextInt(100));
    }

    public void entrouSala(Personagem heroi){
        Random gerador= new Random();
        if(gerador.nextInt(10)>5){
            heroi.setVida(modificadorVida);
        }
        else{
            heroi.recebeDano(modificadorVida);
        }
    }

}
