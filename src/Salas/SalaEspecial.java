package src.Salas;

import java.util.Random;

import src.Entidade.Personagem.Personagem;

public class SalaEspecial extends Sala{
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
            setNome("Sala de Cura");
        }
        else{
            heroi.recebeDano(modificadorVida);
            setNome("Sala de Armadilha");
        }
    }

}
