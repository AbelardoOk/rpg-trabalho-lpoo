package src.main.view;

import java.util.List;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Monstro.Monstro;
import src.main.model.Entidade.Personagem.Personagem;

public class BattleScreen {
    public void draw(TextGraphics tg, Personagem heroi, Monstro inimigo, List<String> logMessages, int OpcaoSelecionada, int level) {
        tg.putString(16, 3, "== NÍVEL " + level + " ==");
        tg.putString(5, 4, "== HERÓI ==");
        tg.putString(7, 5, "Nome: " + heroi.getNome());
        tg.putString(7, 6, "HP = " + heroi.getVidaAtual() + "/" + heroi.getVidaMaxima());

        tg.putString(30, 4, "== INIMIGO ==");
        tg.putString(32, 5, "Nome: " + inimigo.getNome());
        tg.putString(32, 6, "HP = " + inimigo.getVidaAtual() + "/" + inimigo.getVidaMaxima());

        if (logMessages.isEmpty() != true) {
            tg.putString(5,8, logMessages.get(0));
            logMessages.remove(0);
            tg.putString(5,9, logMessages.get(0));
            logMessages.remove(0);
        }

        tg.putString(5, 11, "== AÇÕES ==");
        tg.putString(5, 12, (OpcaoSelecionada == 0 ? ">" : " ") + " Atacar");
        tg.putString(5, 13, (OpcaoSelecionada == 1 ? ">" : " ") + " Defender");

        
    }   
}
