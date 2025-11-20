package src.main.view;

import java.util.List;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Monstro.Monstro;
import src.main.model.Entidade.Personagem.Personagem;

public class BattleScreen {

    private void drawHealthBar(TextGraphics tg, int x, int y, int vidaAtual, int vidaMaxima, int comprimento) {
        if (vidaMaxima <= 0) {
            return;
        }

        double percentualVida = (double) vidaAtual / vidaMaxima;
        int preenchidos = (int) (percentualVida * comprimento);
        
        char cheio = '█'; 
        char vazio = '░';

        for (int i = 0; i < preenchidos; i++) {
            tg.putString(x + i, y, String.valueOf(cheio));
        }

        for (int i = preenchidos; i < comprimento; i++) {
            tg.putString(x + i, y, String.valueOf(vazio));
        }
    }

    public void draw(TextGraphics tg, Personagem heroi, Monstro inimigo, List<String> logMessages, int OpcaoSelecionada, int level) {
        tg.putString(16, 3, "== NÍVEL " + level + " ==");
        tg.putString(5, 4, "== HERÓI ==");
        tg.putString(7, 5, "Nome: " + heroi.getNome());
        tg.putString(7, 6, "HP = " + heroi.getVidaAtual() + "/" + heroi.getVidaMaxima());

        int comprimentoBarra = 20;
        this.drawHealthBar(tg, 7, 7, (int) heroi.getVidaAtual(), (int) heroi.getVidaMaxima(), comprimentoBarra);

        tg.putString(30, 4, "== INIMIGO ==");
        tg.putString(32, 5, "Nome: " + inimigo.getNome());
        tg.putString(32, 6, "HP = " + inimigo.getVidaAtual() + "/" + inimigo.getVidaMaxima());

        this.drawHealthBar(tg, 32, 7, (int) inimigo.getVidaAtual(), (int) inimigo.getVidaMaxima(), comprimentoBarra);

        if (logMessages.isEmpty() != true) {
            tg.putString(5,8, logMessages.get(0));
            logMessages.remove(0);
            tg.putString(5,9, logMessages.get(0));
            logMessages.remove(0);
        }

        tg.putString(5, 11, "== AÇÕES ==");
        tg.putString(5, 12, (OpcaoSelecionada == 0 ? ">" : " ") + " Atacar");
        tg.putString(5, 13, (OpcaoSelecionada == 1 ? ">" : " ") + " Inventário");

        
    }   
}
