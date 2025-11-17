package src.main.model.Item.pocao;

import src.main.model.Entidade.Entidade;
import src.main.model.Item.Item;

public abstract class Pocao extends Item{
    private int eficacia;

    public void setEficacia(int eficacia) {
        this.eficacia = eficacia;
    }

    public int getEficacia() {
        return eficacia;
    }

    public abstract void consumir(Entidade p);

}
