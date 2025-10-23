package src.Personagem;

import java.util.Random;
import src.Monstro.Monstro;

public class Mago extends Personagem {

  @Override
  public void atacar(Monstro monstro) {
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
