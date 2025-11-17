package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Entidade.Monstro.Monstro;
import src.main.view.BattleScreen;

import java.util.ArrayList;
import java.util.List;

public class BattleController {
    private Screen screen;
    	private TextGraphics tg;
    	private BattleScreen bs;
    	private Personagem heroi;
    	private Monstro inimigo;
		private SwingTerminalFrame terminal;

	public BattleController(Screen screen, TextGraphics tg, BattleScreen bs, Personagem heroi, Monstro inimigo, SwingTerminalFrame terminal) {
        	this.screen = screen;
        	this.tg = tg;
        	this.bs = bs;
        	this.heroi = heroi;
        	this.inimigo = inimigo;
			this.terminal = terminal;
    	}

    public boolean run() throws java.io.IOException {
        List<String> lista = new ArrayList<>(); //remover

		while(heroi.estaVivo() && inimigo.estaVivo()) {
			screen.clear();
			bs.draw(tg, heroi, inimigo, lista);
			screen.refresh();

			KeyStroke key = screen.readInput();
			
			if (key == null) {continue;}

			switch (key.getKeyType()) {
				case Character:
				 	char c = key.getCharacter();
					if (c == '1') {
						System.out.println("Ataca");
						heroi.atacar(inimigo);
					}
					else if (c == '2') {
						heroi.defender();
					}
			
					if (inimigo.estaVivo() && (c == '1' || c == '1')) {
						inimigo.atacar(heroi);
        			}
					break;

				case Escape:
					screen.stopScreen();
					terminal.close();
					System.exit(0);
					break;

				default:
					break;
			}

			
		}
		
		return heroi.estaVivo();
	}

}
