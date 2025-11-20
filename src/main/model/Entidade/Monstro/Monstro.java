package src.main.model.Entidade.Monstro;

import java.util.Random;

import src.main.model.Entidade.Entidade;

public class Monstro extends Entidade {
    private int base_Atributo;
    private Random rand = new Random();

    public int getBase_Atributo() {
        return base_Atributo;
    }

    public Monstro(String nome, int nivel) {
      super(nome, nivel);

      this.base_Atributo = 5 + rand.nextInt(10);
      int nivelBase = nivel;
      float modificadorNivel = 1.0f;

      if(nivel%3==0) {
          modificadorNivel = 1.5f;
      }

      int fatorNivel = Math.max(1, nivelBase);
      int forcaBase = Math.round(this.base_Atributo * modificadorNivel * fatorNivel * 1.0f);
      int defesaBase = Math.round(this.base_Atributo * modificadorNivel * fatorNivel * 0.8f);
      int vidaBase = Math.round(this.base_Atributo * modificadorNivel * fatorNivel * 4.0f);

      setForca(Math.max(1, forcaBase));
      setVidaMaxima(getVidaMaxima() + vidaBase);
      setDefesa(Math.max(1, defesaBase));
    }

    public String atacar(Entidade entidade){
        int danobase = getForca();
        int variacaoMaxima = Math.max(1, danobase / 5);
        int variacao = rand.nextInt(2 * variacaoMaxima + 1) - variacaoMaxima;
        int dano = Math.max(1, variacao + danobase);

        System.out.println(this.getNome() + " atacou com força " + dano + " de dano\n");
        if(defender()){
          entidade.recebeDano(dano);
          return String.format("%s Atacou com %d de dano (%s PERDE %d)", super.getNome(), dano, entidade.getNome(), dano);
        } else{
          return String.format("%s atacou, mas %s se esquivou do ataque!", super.getNome(), entidade.getNome());
        }
    }
}
