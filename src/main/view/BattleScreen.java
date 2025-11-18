package src.main.view;

import java.util.List;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Monstro.Monstro;
import src.main.model.Entidade.Personagem.Personagem;

public class BattleScreen {
    public void draw(TextGraphics tg, Personagem heroi, Monstro inimigo, List<String> logMessages, int OpcaoSelecionada) {
        tg.putString(5, 3, "== HERÓI ==");
        tg.putString(7, 4, "Nome: " + heroi.getNome());
        tg.putString(8, 5, "HP = " + heroi.getVidaAtual() + "/" + heroi.getVidaMaxima());

        tg.putString(30, 3, "== INIMIGO ==");
        tg.putString(32, 4, "Nome: " + inimigo.getNome());
        tg.putString(32, 5, "HP = " + inimigo.getVidaAtual() + "/" + inimigo.getVidaMaxima());

        if (logMessages.isEmpty() != true) {
            tg.putString(5,7, logMessages.get(0));
            logMessages.remove(0);
            tg.putString(5,8, logMessages.get(0));
            logMessages.remove(0);
        }

        tg.putString(5, 10, "== AÇÕES ==");
        tg.putString(5, 11, (OpcaoSelecionada == 0 ? ">" : " ") + " Atacar");
        tg.putString(5, 12, (OpcaoSelecionada == 1 ? ">" : " ") + " Defender");

        
    }   
}
