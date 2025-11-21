package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Entidade.Monstro.Monstro;
import src.main.view.BattleScreen;
import src.main.view.InventoryScreen;
import src.main.model.Item.pocao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleController {
    private Screen screen;
	private TextGraphics tg;
	private BattleScreen bs;
	private InventoryScreen is;
	private Personagem heroi;
	private Monstro inimigo;
	private SwingTerminalFrame terminal;
	private int OpcaoSelecionada = 0;
	private String log;
	private int nivel;
	private int exp;
	List<String> lista = new ArrayList<>();


	public BattleController(Screen screen, TextGraphics tg, BattleScreen bs, InventoryScreen is, Personagem heroi, Monstro inimigo, SwingTerminalFrame terminal, int nivel) {
        	this.screen = screen;
        	this.tg = tg;
        	this.bs = bs;
			this.is = is;
        	this.heroi = heroi;
        	this.inimigo = inimigo;
			this.terminal = terminal;
			this.nivel = nivel;
    	}

    public boolean run() throws java.io.IOException {
		while(heroi.estaVivo() && inimigo.estaVivo()) {
			screen.clear();
			bs.draw(tg, heroi, inimigo, lista, OpcaoSelecionada, nivel);
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

	private void Acao() throws java.io.IOException {
		switch (OpcaoSelecionada) {
			
			case 0:
				log = heroi.atacar(inimigo);
				lista.add(log);
				if (inimigo.estaVivo()) {log = inimigo.atacar(heroi); lista.add(log);}
				else{
					Random gerador=new Random();
					this.exp=gerador.nextInt(nivel*10)+nivel*6;
					heroi.evoluir(exp);
				}
				break;
			case 1:
				InventoryController inventoryController = new InventoryController(screen, tg, is, heroi, inimigo, terminal);
				ArrayList<Pocao> p = new ArrayList<>();
				p = inventoryController.run();
				heroi.setPocoes(p);
				break;
		
			default:
				break;
		}
	}

	public int getExp(){
		return this.exp;
	}

}
