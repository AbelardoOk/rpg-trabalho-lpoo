package src.main.model.Entidade;

import java.util.Random;


public abstract class Entidade {
    private String nome;
    private float vida_atual;
    private float vida_maxima;
    private int forca;
    private int nivel;
    private int defesa;


    public int getDefesa() { return defesa; }
    public int getForca() { return forca; }
    public int getNivel() { return nivel; }
    public String getNome() { return nome; }
    public float getVidaMaxima() { return vida_maxima; }
    public float getVidaAtual() { return vida_atual; }

    public void setDefesa(int defesa) { this.defesa = defesa; }
    public void setForca(int forca) { this.forca = forca; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setNome(String nome) { this.nome = nome; }
    public void setVidaMaxima(float vida) { this.vida_maxima = vida; }
    public void setVidaAtual(float vida) { this.vida_atual = vida; }

    public abstract String atacar(Entidade entidade);

    public Entidade(String nome, int nivel){
        this.nome = nome;
        this.nivel = nivel;
    }
    
    public boolean defender(){
        Random gerador = new Random();
        if(gerador.nextInt() > 4){
            return true;
        } else {
            return false;
        }
    }

    public void recebeDano(float dano){
      this.vida_atual -= dano;
    }

    public boolean estaVivo() {
        return this.vida_atual > 0;
    }
}
