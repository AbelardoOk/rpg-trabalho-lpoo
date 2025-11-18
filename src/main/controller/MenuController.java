package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.view.MenuScreen;

public class MenuController {
    private Screen screen;
	private TextGraphics tg;
	private MenuScreen ms;
	private SwingTerminalFrame terminal;
	private int OpcaoSelecionada = 0;
    private boolean iniciar = false;

	public MenuController(Screen screen, TextGraphics tg, MenuScreen ms, SwingTerminalFrame terminal) {
        	this.screen = screen;
        	this.tg = tg;
        	this.ms = ms;
			this.terminal = terminal;
    	}

    public boolean run() throws java.io.IOException {
         

		while(iniciar != true) {
			screen.clear();
			ms.draw(tg, OpcaoSelecionada);
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
                    Acao();
                    break;

				case Escape:
					encerrar();
					break;

				default:
					break;
			}

			
		}
		
		return iniciar;
	}

	private void Acao() {
		switch (OpcaoSelecionada) {
			
			case 0:
				iniciar = true;
				break;
			case 1:
				encerrar();
                break;
		
			default:
				break;
		}
	}

    private void encerrar()  {
        try {
            screen.stopScreen();
            terminal.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
