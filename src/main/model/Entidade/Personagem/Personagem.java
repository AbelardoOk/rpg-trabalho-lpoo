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
        int ganhoVida = rand.nextInt(range) + minGanho;

        setForca(getForca() + ganhoForca);
        setDefesa(getDefesa() + ganhoDefesa);
        setVidaMaxima(getVidaMaxima() + ganhoVida);

      }
    }

    public String atacar(Entidade entidade){
        int dano = rand.nextInt(getDefesa()) * getForca();
        if(!defender()){
          entidade.recebeDano(dano);
          return super.getNome() + " recebeu " + dano + " de dano\n";
        } else{
          return super.getNome() +  " se esquivou do ataque\n";
        }
    };
}

