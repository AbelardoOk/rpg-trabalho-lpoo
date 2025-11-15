package src.main.model.Entidade.Monstro;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class Monstro extends Entidade {
    private static int base_Atributo = (int) (Math.random() * 10);

    public int getBase_Atributo() {
        return base_Atributo;
    }

    public Monstro(String nome, int nivel) {
      super(nome, nivel);

      if(nivel%3==0) {
          setForca(getBase_Atributo() * (nivel+3));
          setNivel(1);
          setVidaMaxima((Math.round(getBase_Atributo()* 0.5 *(nivel+3))));
          setVidaAtual(getVidaMaxima());
          setDefesa(getBase_Atributo() *(nivel+3));
      }
      else{
          setForca(getBase_Atributo() * nivel);
          setNivel(1);
          setVidaMaxima(Math.round(getBase_Atributo()* 0.5 * nivel));
          setVidaAtual(getVidaMaxima());
          setDefesa(getBase_Atributo() * nivel);

      }
    }

    public void atacar(Entidade entidade){
        Random gerador = new Random();
        float dano = gerador.nextInt(getDefesa()) * getForca();
        if(!defender()){
          entidade.recebeDano(dano);
          System.out.println(super.getNome() + " recebeu " + dano + " de dano\n");
        } else{
          System.out.println(super.getNome() + " se esquivou do ataque!\n");
        }
    }
}
