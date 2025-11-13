package src.Item.Pocoes;

import src.Item.Pocao;
import src.Entidade.Entidade;

import java.util.Random;

public class Cura extends Pocao {
  public Cura(){
    Random gerador = new Random();
    setEficacia(gerador.nextInt());
  }

  public void consumir(Entidade p){
    p.setVida(p.getVida() + getEficacia());
  }
  
}
