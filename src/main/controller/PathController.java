package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.view.PathBattleScreen;
import src.main.view.PathScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PathController {
    private Screen screen;
	private TextGraphics tg;
	private PathScreen ps = null;
    private PathBattleScreen pbs = null;
	private Personagem heroi;
	private SwingTerminalFrame terminal;
	private int OpcaoSelecionada = 0;
	List<String> lista = new ArrayList<>();

	public PathController(Screen screen, TextGraphics tg, PathScreen ps, PathBattleScreen pbs, Personagem heroi, SwingTerminalFrame terminal) {
        this.screen = screen;
        this.tg = tg;
        this.ps = ps;
        this.pbs = pbs;
        this.heroi = heroi;
        this.terminal = terminal;
    }

    public String run() throws java.io.IOException {
         

		while(true) {
            if (pbs == null) {
                screen.clear();
                ps.draw(tg, heroi, OpcaoSelecionada);
                screen.refresh();
            }
            else {
                screen.clear();
                pbs.draw(tg, heroi, OpcaoSelecionada);
                screen.refresh();
            }

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
                    return Acao();

				case Escape:
					screen.stopScreen();
					terminal.close();
					System.exit(0);
					break;

				default:
					break;
			}

			
		}
		
	}

	private String Acao() {
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance < 60) {
            return "IN_BATTLE";
        } 
        
        else if (chance < 80) {
            return "IN_BATTLE"; // Sala Item
        } 
        
        else {
            return "IN_BATTLE"; // Sala especial
        }

	}

}
