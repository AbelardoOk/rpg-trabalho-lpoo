package src.Item;

import src.Entidade.Entidade;
import java.util.Random;

public class PocaoCura extends Item {
  private int eficacia;

  public void setEficacia(int eficacia) {
    this.eficacia = eficacia;
  }

  public int getEficacia() {
    return eficacia;
  }

  public void consumir(Entidade p){
    float vida;
    vida=p.getVida() + getEficacia();
    if(vida>100){
      vida=vida-100;
      p.setVida(vida);
    }else{
      p.setVida(vida);
    }
    
  }

  
  @Override 
  public String toString() {
    return super.toString()+" Vida Maxima Curada:"+ this.eficacia+"\n";
  }

  public PocaoCura(){
    setNome("Pocao de Cura");
    Random gerador = new Random();
    setEficacia(gerador.nextInt(50));
  }

  

}
