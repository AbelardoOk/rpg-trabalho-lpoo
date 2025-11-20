package src.main.model.Salas;

import java.util.Random;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Item.*;
import src.main.model.Item.pocao.PocaoCura;

public class SalaItem extends Sala{
    Item ferramenta;
    
    Item getFerramenta(){
        return this.ferramenta;
    }
    void setFerramenta(Item ferramenta){
        this.ferramenta=ferramenta;
    }
    
    public void entrouSala(Personagem heroi){
        Random gerador=new Random();
        if(gerador.nextInt(10)>5){
           setFerramenta(new PocaoCura(heroi.getNivel()));
        }else{
            setFerramenta(new Arma());
        }
        
    }
}
