package src.Item;

import java.util.Random;

public class Arma  extends Item{
    private int dano;
    private int quantiaUsos;


    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDano() {
        return this.dano;
    }

    public void setQuantiaUsos(int quantiaUsos){
        this.quantiaUsos=quantiaUsos;
    }
    public int getQuantiaUsos(){
        return this.quantiaUsos;
    }


    public Arma(){
        setNome("Arma");

        Random gerador= new Random();
        setDano(gerador.nextInt(100));
        setQuantiaUsos(gerador.nextInt(50));

    }

}
