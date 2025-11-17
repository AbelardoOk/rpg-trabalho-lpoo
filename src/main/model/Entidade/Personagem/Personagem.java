package src.main.model.Entidade.Personagem;

import src.main.model.Entidade.Entidade;
import src.main.model.Item.*;

import java.util.ArrayList;
import java.util.Random;

public class Personagem extends Entidade {
    private int experiencia;
    ArrayList<Item> itens=new ArrayList<>();

    public void setExperiencia(int exp) { this.experiencia = exp; }
    public int getExperiencia() { return experiencia; }

    public void setItens(Item item){
      this.itens.add(item);  
    }

    public int QuantidadeItens(){
      return this.itens.size();
    }

    public String ImprimirItens(){ //retorna uma string por causa da interface
      String texto;
      int cont=1;
      if (this.itens.isEmpty()) {
        return "O inventário está vazio.";
      }else{
        texto=getNome()+" possui os seguinte(s) item(ns): \n";
        for(Item aux:itens){
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
      if(getExperiencia() > 100){
        System.out.println(super.getNome() + " evoluiu um nível!");
        setExperiencia(getExperiencia() - 100);
        // Sistema para melhorar atributos
      }
    }

    public void atacar(Entidade entidade){
        Random gerador = new Random();
        int dano = gerador.nextInt(getDefesa()) * getForca();
        if(!defender()){
          entidade.recebeDano(dano);
          System.out.println(entidade.getNome() + " recebeu " + dano + " de dano\n");
        } else{
          System.out.println(entidade.getNome() +  " se esquivou do ataque\n");
        }
    };
}

