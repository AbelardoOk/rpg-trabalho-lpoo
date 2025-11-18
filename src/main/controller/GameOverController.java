package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.view.GameOverScreen;

public class GameOverController {
    private Screen screen;
	private TextGraphics tg;
	private GameOverScreen gs;
	private SwingTerminalFrame terminal;

	public GameOverController(Screen screen, TextGraphics tg, GameOverScreen gs, SwingTerminalFrame terminal) {
        	this.screen = screen;
        	this.tg = tg;
        	this.gs = gs;
			this.terminal = terminal;
    	}

    public void run() throws java.io.IOException {
         
        System.out.println("AQUIII");
		while(true) {
            
			screen.clear();
			gs.draw(tg);
			screen.refresh();

			KeyStroke key = screen.readInput();
			
			if (key == null) {continue;}

			switch (key.getKeyType()) {
                case Enter:
                    encerrar();
                    break;

				case Escape:
					encerrar();
					break;

				default:
					break;
			}

			
		}
	}

    public void encerrar()  {
        try {
            screen.stopScreen();
            terminal.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}

