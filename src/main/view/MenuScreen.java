package src.main.view;


import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuScreen {
    public void draw(TextGraphics tg, int OpcaoSelecionada) {
        tg.putString(5, 3, "===== DARK ADVENTURES =====");

        tg.putString(5, 10, "== MENU ==");
        tg.putString(5, 11, (OpcaoSelecionada == 0 ? ">" : " ") + " Novo Jogo");
        tg.putString(5, 12, (OpcaoSelecionada == 1 ? ">" : " ") + " Sair");
    }   
}
