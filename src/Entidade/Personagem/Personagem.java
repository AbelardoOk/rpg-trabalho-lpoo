package src.Entidade.Personagem;

import src.Entidade.Entidade;
import java.util.Random;

public abstract class Personagem extends Entidade {

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

