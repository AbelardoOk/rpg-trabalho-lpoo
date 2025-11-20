package src.main.model.Entidade.Personagem;

import src.main.model.Entidade.Entidade;
import src.main.model.Item.pocao.*;
import src.main.model.Item.*;

import java.util.ArrayList;
import java.util.Random;

public class Personagem extends Entidade {
    private int experiencia;
    private Arma arma;
    private Random rand = new Random();
    ArrayList<Pocao> pocoes=new ArrayList<>();


    public void setExperiencia(int exp) { this.experiencia = exp; }
    public int getExperiencia() { return experiencia; }

    public void setPocoes(Pocao pocao){
      this.pocoes.add(pocao);  
    }

    public int QuantidadePocoes(){
      return this.pocoes.size();
    }
     public void setArma(Arma arma){
        this.arma=arma;
    }

    public Arma getArma(){
      return this.arma;
    }

    public String ImprimirPocoes(){
      String texto;
      int cont=1;
      if (this.pocoes.isEmpty()) {
        return "O inventário está vazio.";
      }else{
        texto=getNome()+" possui os seguinte(s) item(ns): \n";
        for(Pocao aux:pocoes){
         texto=cont+texto+aux;
         cont++;
        }
        
        return texto;
      }
    }

    public Personagem(String nome, float vida_maxima, int forca, int nivel, int defesa, int experiencia) {
      super(nome, nivel);
      setExperiencia(experiencia);
      setVidaMaxima(vida_maxima);
      setVidaAtual(vida_maxima);
      setForca(forca);
      setDefesa(defesa);
    }


    public void evoluir(int exp){
      setExperiencia(getExperiencia() + exp);

      while(getExperiencia() >= 100){
        setNivel(getNivel() + 1);
        setExperiencia(getExperiencia() - 100);

        int minGanho = (getNivel() / 2) + 1;
        int maxGanho = getNivel();
        int range = maxGanho - minGanho + 1;

        int ganhoForca = rand.nextInt(range) + minGanho;
        int ganhoDefesa = rand.nextInt(range) + minGanho;
        
        int minGanhoVida = (getNivel() * 3) + 5;
        int maxGanhoVida = (getNivel() * 5) + 10;
        int rangeVida = maxGanhoVida - minGanhoVida + 1;
        int ganhoVida = rand.nextInt(rangeVida) + minGanhoVida;

        setForca(getForca() + ganhoForca);
        setDefesa(getDefesa() + ganhoDefesa);
        setVidaMaxima(getVidaMaxima() + ganhoVida);
        setVidaAtual(getVidaAtual() + ganhoVida);
      }
    }

    public String atacar(Entidade entidade){
        int danobaseTotal = arma.getDano() + this.getForca();

        int variacaoMaxima = Math.max(1, danobaseTotal / 8);
        int variacao = rand.nextInt(2 * variacaoMaxima + 1) - variacaoMaxima;
        int dano = Math.max(1, variacao + danobase);

        System.out.println(this.getNome() + " atacou com força " + dano + " de dano");
        if(!defender()){
          entidade.recebeDano(dano);
          return String.format("%s Atacou com %d de dano (%s PERDE %d)", super.getNome(), dano, entidade.getNome(), dano);
        } else{
          return String.format("%s atacou, mas %s se esquivou do ataque!", super.getNome(), entidade.getNome());
        }
    };
}

