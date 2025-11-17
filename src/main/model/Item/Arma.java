package src.main.model.Item;

import java.util.Random;

public class Arma  extends Item{
    private int dano;
    private int quantiaUsos;

    public int getDano() {
        return this.dano;
    }
    
    public int getQuantiaUsos(){
        return this.quantiaUsos;
    }

    @Override 
    public String toString() {
        return super.toString()+" Dano Maximo:"+ this.dano+"\nQuantidade de usos restantes:"+this.quantiaUsos+"/n";
    }

    public Arma(){
        setNome("Arma");

        Random gerador= new Random();
        setDano(gerador.nextInt(100));
        setQuantiaUsos(gerador.nextInt(50));

    }



}
