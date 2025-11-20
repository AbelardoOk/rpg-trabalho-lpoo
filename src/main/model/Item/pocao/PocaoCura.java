package src.main.model.Item.pocao;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class PocaoCura extends Pocao {
  
  public void consumir(Entidade p){
    float vida;
    vida=p.getVidaAtual() + getEficacia();
    if(vida>p.getVidaMaxima()){
      vida=p.getVidaMaxima();
      p.setVidaAtual(vida);
    }else{
      p.setVidaAtual(vida);
    }
    
  }

  
  @Override 
  public String toString() {
    return super.toString()+" Vida Maxima Curada:"+ this.getEficacia()+"\n";
  }

  public PocaoCura(){
    setNome("Pocao de Cura");
    Random gerador = new Random();
    setEficacia(gerador.nextInt(50));
  }

  

}
