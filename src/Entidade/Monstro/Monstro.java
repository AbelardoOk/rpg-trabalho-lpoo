package src.Entidade.Monstro;

import java.util.Random;

import src.Entidade.Entidade;

public abstract class Monstro extends Entidade {
    public void atacar(Entidade entidade){
        Random gerador = new Random();
        int dano = gerador.nextInt(getDefesa()) * getForca();
        if(!defender()){
          entidade.recebeDano(dano);
          System.out.println(getNome() + " recebeu " + dano + "de dano\n");
        } else{
          System.out.println(getNome() + " se esquivou do ataque!\n");
        }
    }
}
