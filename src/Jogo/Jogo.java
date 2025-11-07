package src.Jogo;

import src.Entidade.Monstro.*;
import src.Entidade.Personagem.*;

public class Jogo {
  static int recorde;
  int faseAtual;
  int monstrosDerrotados;

  public void controlarPartida(){
    this.faseAtual = 1;
    this.monstrosDerrotados = 0;

    Personagem heroi = new Personagem("Conan");
    boolean heroiEstaVivo = true;

    while (heroiEstaVivo){
      System.out.println("\n=======================");
      System.out.println("      FASE " + this.faseAtual);
      System.out.println("=======================");
      
      Monstro inimigo = new Monstro("Monstro Nv." + this.faseAtual, this.faseAtual);
      heroiEstaVivo = this.iniciarBatalha(heroi, inimigo);

      if (heroiEstaVivo) {
        this.monstrosDerrotados++;
          this.faseAtual++;
          if(heroi.getVida() < 50) {heroi.curar();}
          System.out.println(heroi.getNome() + " avança para a próxima fase...");
      }
    }

    this.exibirFimDeJogo(heroi);
  }

  public boolean iniciarBatalha(Personagem heroi, Monstro inimigo){

      int turno = 1;
      System.out.println("--- Inimigo: " + inimigo.getNome() + " apareceu! ---");
      
      while(heroi.estaVivo() && inimigo.estaVivo()){
        System.out.println("\n--- Turno " + turno + " ---");

        System.out.println(heroi.getNome() + " (Vida: " + heroi.getVida() + ")");
        System.out.println(inimigo.getNome() + " (Vida: " + inimigo.getVida() + ")");

        heroi.atacar(inimigo);
            
        if (inimigo.estaVivo()) {
          inimigo.atacar(heroi);
        }

        turno++;
      }
      System.out.println("\n--- Batalha Encerrada ---");
        if (heroi.estaVivo()) {
            System.out.println(heroi.getNome() + " é o vencedor!");
            return true;
        } else {
            System.out.println(inimigo.getNome() + " é o vencedor!");
            System.out.println(heroi.getNome() + " foi derrotado.");
            return false;
        }
  }

  public void exibirFimDeJogo(Personagem heroi){
      System.out.println("\n--- FIM DE JOGO ---");
      System.out.println("Herói: " + heroi.getNome());
      System.out.println("Monstros Derrotados: " + this.monstrosDerrotados);
      System.out.println("Fase Alcançada: " + this.faseAtual);

      if (this.monstrosDerrotados > recorde) {
          recorde = this.monstrosDerrotados;
          System.out.println("NOVO RECORDE!");
      }
  }

  public static void main(String[] args) {
        Jogo novoJogo = new Jogo();
        novoJogo.controlarPartida();
    }

}
