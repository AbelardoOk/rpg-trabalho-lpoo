package src.main.view;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Personagem.Personagem;

public class PathBattleScreen {
    public void draw(TextGraphics tg, Personagem heroi, int OpcaoSelecionada) {
        tg.putString(5, 3, "           == CORREDOR ==                ");
        tg.putString(7, 4, "VOCÊ DERROTOU O MONSTRO E GANHOU 14 DE EXP");
        tg.putString(7, 6, "VOCÊ VÊ DUAS SALAS A SUA FRENTE");
        tg.putString(7, 7, "SÓ UM CAMINHO PODE TE LEVAR AO FIM DISSO!");


        tg.putString(5, 10, "== AÇÕES ==");
        tg.putString(5, 11, (OpcaoSelecionada == 0 ? ">" : " ") + " SALA 1");
        tg.putString(5, 12, (OpcaoSelecionada == 1 ? ">" : " ") + " SALA 2");

        
    }   
}
