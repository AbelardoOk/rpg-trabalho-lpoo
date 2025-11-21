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
	private int OpcaoSelecionada = 0;
	private int numero = 0;
	private int maior_nivel=0;
	private String nome_melhor=null;

	public GameOverController(Screen screen, TextGraphics tg, GameOverScreen gs, SwingTerminalFrame terminal, int maior_nivel, String nome_melhor) {
        	this.screen = screen;
        	this.tg = tg;
        	this.gs = gs;
			this.terminal = terminal;
			this.maior_nivel = maior_nivel;
			this.nome_melhor = nome_melhor;
    	}

    public int run() throws java.io.IOException {
         
		while(numero == 0) {
            
			screen.clear();
			gs.draw(tg, OpcaoSelecionada, maior_nivel, nome_melhor);
			screen.refresh();

			KeyStroke key = screen.readInput();
			
			if (key == null) {continue;}

			switch (key.getKeyType()) {
				case ArrowUp:
                    OpcaoSelecionada--;
                    if (OpcaoSelecionada < 0) OpcaoSelecionada = 1;
                    break;

                case ArrowDown:
                    OpcaoSelecionada++;
                    if (OpcaoSelecionada > 1) OpcaoSelecionada = 0;
                    break;

                case Enter:
                    numero = Acao();
                    break;

				case Escape:
					encerrar();
					break;

				default:
					break;
			}

			
		}
		return numero;
	}

	private int Acao() throws java.io.IOException {
		switch (OpcaoSelecionada) {
			
			case 0:
				return 1;
			case 1:
				encerrar();
				break;
		}
		return 0;
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

