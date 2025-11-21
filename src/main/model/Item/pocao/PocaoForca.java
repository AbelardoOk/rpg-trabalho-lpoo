package src.main.model.Item.pocao;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class PocaoForca extends Pocao {
 
 public  void consumir(Entidade p){
        p.setVidaMaxima(0);
}


  public PocaoForca(){
    Random gerador = new Random();
    setEficacia(gerador.nextInt(50));
    setNome("Pocao de Forca (+"+this.getEficacia()+")");
  }

    
}
