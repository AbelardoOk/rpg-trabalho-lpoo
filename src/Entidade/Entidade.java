package src.Entidade;

import java.util.Random;


public abstract class Entidade {
    private String nome;
    private float vida;
    private int forca;
    private int nivel;
    private int defesa;
    
    public int getDefesa() { return defesa; }
    public int getForca() { return forca; }
    public int getNivel() { return nivel; }
    public String getNome() { return nome; }
    public float getVida() { return vida; }

    public void setDefesa(int defesa) { this.defesa = defesa; }
    public void setForca(int forca) { this.forca = forca; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setNome(String nome) { this.nome = nome; }
    public void setVida(float vida) { this.vida = vida; }

    public abstract void atacar(Entidade entidade);

    public boolean defender(){
        Random gerador = new Random();
        if(gerador.nextInt() > 4){
            return true;
        } else {
            return false;
        }
    }

    public void recebeDano(float dano){
      this.vida -= dano;
    }
}
