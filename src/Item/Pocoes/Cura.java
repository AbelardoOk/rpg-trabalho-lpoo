package src.Item.Pocoes;

import src.Item.Pocao;
import src.Personagem.Personagem;

import java.util.Random;

public class Cura extends Pocao {

  public Cura(){
    Random gerador = new Random();
    setEficacia(gerador.nextInt());
  }

  public void consumir(Personagem p){
    p.setVida(p.getVida() + getEficacia());
  }
  
}
