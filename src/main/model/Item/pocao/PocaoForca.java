package src.main.model.Item.pocao;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class PocaoForca extends Pocao {
 
 public  void consumir(Entidade p){
  p.setForca(this.getEficacia());
 }




  public PocaoForca(int nivel){
    Random gerador = new Random();
    setEficacia(gerador.nextInt(nivel)+10);
    setNome("Pocao de Forca (+"+this.getEficacia()+")");
  }

    
}
