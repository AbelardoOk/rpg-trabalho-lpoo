package src.Entidade.Personagem;

import src.Entidade.Entidade;
import src.Item.Pocoes.Cura;

import java.util.Random;

public class Personagem extends Entidade {
    private int curas;

    public void setCuras(int curas) {
      this.curas = curas;
    }

    public Personagem(String nome) {
      super(nome);
      setForca(10);
      setNivel(1);
      setVida(100);
      setDefesa(10);
      setCuras(5);
    }

    public void curar(){
      if(curas > 0){
        Cura pocao = new Cura();
        pocao.consumir(this);
      }
    }

    public void atacar(Entidade entidade){
        Random gerador = new Random();
        int dano = gerador.nextInt(getDefesa()) * getForca();
        if(!defender()){
          entidade.recebeDano(dano);
          System.out.println("Você recebeu " + dano + "de dano\n");
        } else{
          System.out.println("Você se esquivou do ataque\n");
        }
    };
}

