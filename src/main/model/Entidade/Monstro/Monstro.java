package src.main.model.Entidade.Monstro;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class Monstro extends Entidade {
    private static int base_Atributo = (int) (Math.random() * 10);
    private Random rand = new Random();

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

    public String atacar(Entidade entidade){
        int danobase = getForca();
        int variacao = rand.nextInt(Math.max(1, danobase / 5));
        int dano = variacao + danobase;

        System.out.println(this.getNome() + " atacou com força " + dano + " de dano\n");
        if(defender()){
          entidade.recebeDano(dano);
          return String.format("%s Atacou com %d de dano (%s PERDE %d)", super.getNome(), dano, entidade.getNome(), dano);
        } else{
          return String.format("%s atacou, mas %s se esquivou do ataque!", super.getNome(), entidade.getNome());
        }
    }
}
