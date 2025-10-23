package src.Monstro;

import src.Personagem.Personagem;
import java.util.Random;

public abstract class Monstro {
    private String nome;
    private float vida;
    private int forca;
    private int nivel;
    private int defesa;

    public int getDefesa() {
      return defesa;
    }

    public int getForca() {
      return forca;
    }

    public int getNivel() {
      return nivel;
    }

    public String getNome() {
      return nome;
    }
    
    public float getVida() {
      return vida;
    }

    public void setDefesa(int defesa) {
      this.defesa = defesa;
    }

    public void setForca(int forca) {
      this.forca = forca;
    }

    public void setNivel(int nivel) {
      this.nivel = nivel;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public void setVida(int vida) {
      this.vida = vida;
    }

    public void atacar(Personagem heroi){
        Random gerador = new Random();
        int dano = gerador.nextInt(defesa) * getForca();
        if(!defender()){
          heroi.recebeDano(dano);
          System.out.println("Você recebeu " + dano + "de dano\n");
        } else{
          System.out.println("Você se esquivou do ataque\n");
        }
    }

    public boolean defender(){
        Random gerador = new Random();
        if(gerador.nextInt(defesa) > 4){
            return true;
        } else {
            return false;
        }
    }

    public void recebeDano(float dano){
      this.vida -= dano;
    }

}
