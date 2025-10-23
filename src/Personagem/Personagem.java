package src.Personagem;
import java.util.Random;

abstract class Personagem {
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
    
    public int getVida() {
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

    public void atacar(Monstro monstro){
        Random gerador = new Random();
        int dano = gerador.nextInt(defesa) * getForca();
        monstro.recebeDano(dano);
        System.out.println("Você deu " + dano + "de dano em " + monstro.getNome() + "\n");
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

