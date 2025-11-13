package src.Item;

import src.Entidade.Entidade;

public abstract class Pocao {
  private int eficacia;

  public void setEficacia(int eficacia) {
    this.eficacia = eficacia;
  }

  public int getEficacia() {
    return eficacia;
  }

  public abstract void consumir(Entidade p);
}
