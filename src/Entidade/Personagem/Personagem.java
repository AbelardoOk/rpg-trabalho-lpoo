package src.Entidade.Personagem;

import src.Entidade.Entidade;
import src.Item.*;

import java.util.ArrayList;
import java.util.Random;

public class Personagem extends Entidade {
    private int curas;
    private int experiencia;
    ArrayList<Item> itens=new ArrayList<>();

    public void setCuras(int curas) { this.curas = curas; }
    public int getCuras() { return curas; }

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
        return "O carrinho está vazio.";
      }else{
        texto=getNome()+" possui os seguinte(s) item(ns): \n";
        for(Item aux:itens){
         texto=cont+texto+aux;
         cont++;
        }
        
        return texto;
      }
    }

    public Personagem(String nome) {
      super(nome);
      setForca(10);
      setNivel(1);
      setVida(100);
      setDefesa(10);
      setCuras(5);
      setExperiencia(0);
    }

    public void curar(){
      if(curas > 0){
        PocaoCura pocao = new PocaoCura();
        pocao.consumir(this);
      }
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
          System.out.println(super.getNome() + " recebeu " + dano + " de dano\n");
        } else{
          System.out.println(super.getNome() +  " se esquivou do ataque\n");
        }
    };
}

