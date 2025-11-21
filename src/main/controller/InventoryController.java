package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Entidade.Monstro.Monstro;
import src.main.model.Item.pocao.*;
import src.main.view.InventoryScreen;

import java.util.ArrayList;

public class InventoryController {
    private Screen screen;
	private TextGraphics tg;
	private InventoryScreen is;
	private Personagem heroi;
    private Monstro inimigo;
	private SwingTerminalFrame terminal;
	private int OpcaoSelecionada = 0;
	ArrayList<Pocao> lista = new ArrayList<>();
    int num=0;
    int TOTAL_OPCOES;

	public InventoryController(Screen screen, TextGraphics tg, InventoryScreen is, Personagem heroi, Monstro inimigo, SwingTerminalFrame terminal) {
        	this.screen = screen;
        	this.tg = tg;
        	this.is = is;
        	this.heroi = heroi;
            this.inimigo = inimigo;
			this.terminal = terminal;
            this.lista = heroi.getPocoes();
    	}

    public ArrayList<Pocao> run() throws java.io.IOException {
        

		while(num==0) {
			screen.clear();
			is.draw(tg, heroi, lista, OpcaoSelecionada);
			screen.refresh();

            TOTAL_OPCOES = lista.size();
			KeyStroke key = screen.readInput();
			
			if (key == null) {continue;}

            if (key.getKeyType() == KeyType.Character) {
                if (OpcaoSelecionada < lista.size()) {
                    char caractere = key.getCharacter();
                    
                    if (caractere == 's' || caractere == 'S') {
                        lista.remove(OpcaoSelecionada); 
                    }
                    if (OpcaoSelecionada >= lista.size()) {
                        OpcaoSelecionada = lista.size(); 
                    }
                }
            }

            else {
                switch (key.getKeyType()) {
                    case ArrowUp:
                        OpcaoSelecionada--;
                        if (OpcaoSelecionada < 0) {
                            OpcaoSelecionada = TOTAL_OPCOES; 
                        }
                        break;

                    case ArrowDown:
                        OpcaoSelecionada++;
                        if (OpcaoSelecionada > TOTAL_OPCOES) {
                            OpcaoSelecionada = 0;
                        }
                        break;
                    
                    case Enter:
                        num = Acao();
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

			
		}
        
        return this.lista;
	}

	private int Acao() throws java.io.IOException {
        if (OpcaoSelecionada < lista.size()) {
            if (lista.get(OpcaoSelecionada).getNome() == "Pocao de Arremessar Letal") {
                lista.get(OpcaoSelecionada).consumir(inimigo);
                lista.remove(OpcaoSelecionada);
            }
            else {
                lista.get(OpcaoSelecionada).consumir(heroi);
                lista.remove(OpcaoSelecionada);
            }
            return 0;
		}
        else if (OpcaoSelecionada == lista.size()) {
            return 1; 
        }
        else {
            return 0;
        }
	}

}
