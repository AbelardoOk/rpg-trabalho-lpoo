package src.Personagem;

import src.Monstro.Monstro;
import java.util.Random;

public class Guerreiro extends Personagem{

        public void atacar(Monstro monstro){
        if(!defender()){
        Random gerador = new Random();
        int dano = gerador.nextInt(5) * getForca();
          monstro.recebeDano(dano);
          System.out.println("Você recebeu " + dano + "de dano\n");
        } else{
          System.out.println("O mosntro se esquivou do ataque\n");
        }
    }

}
