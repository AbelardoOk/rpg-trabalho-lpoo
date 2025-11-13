package src.Entidade.Monstro;

import java.util.Random;

import src.Entidade.Entidade;

public class Monstro extends Entidade {

    public Monstro(String nome, int nivel) {
      super(nome);
      Random gerador = new Random();
      
      setForca(gerador.nextInt(10) * nivel);
      setNivel(1);
      setVida(Math.round(gerador.nextInt(10) * 0.5 * nivel));
      setDefesa(gerador.nextInt(10) * nivel);
    }

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
