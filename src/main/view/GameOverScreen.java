package src.main.view;


import com.googlecode.lanterna.graphics.TextGraphics;

public class GameOverScreen {
    public void draw(TextGraphics tg) {
        tg.putString(5, 3, "===== VOCÊ PERDEU =====");
        tg.putString(5, 12, ">" + " Sair");
    }   
}
