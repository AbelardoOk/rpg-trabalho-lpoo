package src.main.view;


import com.googlecode.lanterna.graphics.TextGraphics;

public class GameOverScreen {
    public void draw(TextGraphics tg, int OpcaoSelecionada, int maior_nivel, String nome_melhor) {
        tg.putString(5, 3, "===== VOCÊ PERDEU =====");

        if (maior_nivel != 0) {
            tg.putString(5, 5, "SEU MELHOR NÍVEL : " + maior_nivel);
            tg.putString(5, 6, "SEU MELHOR HERÓI : " + nome_melhor);
        }

        tg.putString(5, 11, "== AÇÕES ==");
        tg.putString(5, 12, (OpcaoSelecionada == 0 ? ">" : " ") + " NOVO JOGO");
        tg.putString(5, 13, (OpcaoSelecionada == 1 ? ">" : " ") + " SAIR");
    }   
}
