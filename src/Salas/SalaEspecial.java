package src.Salas;

import java.util.Random;

import src.Entidade.Personagem.Personagem;

public class SalaEspecial {
    private float modificadorVida;

    public void setModificadorVida(float vida){
        this.modificadorVida+=vida;        
    }

    public SalaEspecial(){
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
